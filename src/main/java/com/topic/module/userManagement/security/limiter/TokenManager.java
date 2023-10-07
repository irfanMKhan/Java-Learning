package com.topic.module.userManagement.security.limiter;


import com.topic.module.userManagement.model.dto.UserDTO;
import com.topic.module.userManagement.model.security.ValidateToken;
import com.topic.module.userManagement.utility.constant.JwtVariable;
import com.topic.module.userManagement.utility.message.ErrorMessage;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class TokenManager {
    public String generateToken(Authentication authentication) {

        Date tokenIssuedDate = new Date(System.currentTimeMillis());
        Date tokenExpireDate = new Date(tokenIssuedDate.getTime() + JwtVariable.EXPIRATION_TIME_TOKEN);
        Map<String, Object> claims = new HashMap<>();

        UserDTO userPrincipal = (UserDTO) authentication.getPrincipal();

        claims.put(JwtVariable.CLAIM_USER, userPrincipal.getUsername());

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setClaims(claims)
                .setIssuedAt(tokenIssuedDate)
                .setExpiration(tokenExpireDate)
                .signWith(SignatureAlgorithm.HS512, JwtVariable.TOKEN_SECRET_KEY)
                .compact();
    }

    public ValidateToken validateToken(String authToken) {
        ValidateToken validateToken = new ValidateToken();

        try {
            Claims claims = Jwts.parser().setSigningKey(JwtVariable.TOKEN_SECRET_KEY).parseClaimsJws(authToken).getBody();
            validateToken.setSubject(claims.get(JwtVariable.CLAIM_USER).toString());
            validateToken.setStatus(true);
            return validateToken;
        } catch (SignatureException exception) {
            validateToken.setMessage(ErrorMessage.INVALID_TOKEN_SIGNATURE + exception.getMessage());
        } catch (MalformedJwtException exception) {
            validateToken.setMessage(ErrorMessage.INVALID_TOKEN + exception.getMessage());
        } catch (ExpiredJwtException exception) {
            validateToken.setMessage(ErrorMessage.TOKEN_EXPIRED + exception.getMessage());
        } catch (UnsupportedJwtException exception) {
            validateToken.setMessage(ErrorMessage.UNSUPPORTED_TOKEN + exception.getMessage());
        } catch (IllegalArgumentException exception) {
            validateToken.setMessage(ErrorMessage.TOKEN_EMPTY_CLAIMS + exception.getMessage());
        }
        return validateToken;
    }
}

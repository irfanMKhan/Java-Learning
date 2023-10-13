package com.topic.module.userManagement.security.limiter;


import com.topic.module.userManagement.model.dto.UserDTO;
import com.topic.module.userManagement.model.security.ValidateToken;
import com.topic.module.userManagement.utility.constant.JwtVariable;
import com.topic.module.userManagement.utility.message.ErrorMessage;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Slf4j
@Component
public class TokenManager {

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(JwtVariable.TOKEN_SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims getClaims(String token) {
        return Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token).getPayload();
    }

    private String buildToken(Map<String, Object> claims, Authentication authentication, Long expiration) {
        Date tokenIssuedDate = new Date(System.currentTimeMillis());
        Date tokenExpireDate = new Date(tokenIssuedDate.getTime() + expiration);

        UserDTO userPrincipal = (UserDTO) authentication.getPrincipal();

        return Jwts.builder()
                .claims(claims)
                .issuedAt(tokenIssuedDate)
                .expiration(tokenExpireDate)
                .subject(userPrincipal.getUsername())
                .signWith(getSignInKey(), Jwts.SIG.HS512)
                .compact();
    }

    public String getUsername(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(Authentication authentication) {
        return generateToken(new HashMap<>(), authentication);
    }

    public String generateToken(Map<String, Object> claims, Authentication authentication) {
        return buildToken(claims, authentication, JwtVariable.EXPIRATION_TIME_TOKEN);
    }

    public String generateRefreshToken(Authentication authentication) {
        return buildToken(new HashMap<>(), authentication, JwtVariable.EXPIRATION_TIME_REFRESH_TOKEN);
    }

    public ValidateToken validateToken(String token) {
        ValidateToken validateToken = new ValidateToken();

        try {
            Claims claims = getClaims(token);

            validateToken.setSubject(claims.get(JwtVariable.CLAIM_USER).toString());
            validateToken.setStatus(true);

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

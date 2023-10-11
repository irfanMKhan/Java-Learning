package com.topic.module.userManagement.security.filter;


import com.topic.module.userManagement.security.limiter.TokenManager;
import com.topic.module.userManagement.utility.constant.JwtVariable;
import com.topic.module.userManagement.utility.constant.ServletVariable;
import com.topic.module.userManagement.utility.message.ErrorMessage;
import com.topic.module.userManagement.utility.message.LogPurpose;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;

public class AuthenticationTokenFilter extends AuthenticationFilter {
    private final UserService userService;
    private final TokenManager tokenManager;

    @Value("${app.will.use.bucket}")
    private Boolean doUseBucket;

    public AuthenticationTokenFilter(UserService userService, TokenManager tokenManager) {
        super(
                new ProviderManager(Collections.singletonList(new DaoAuthenticationProvider())),
                new BasicAuthenticationConverter()
        );
        this.userService = userService;
        this.tokenManager = tokenManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest servletRequest,
                                    HttpServletResponse servletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String URI = servletRequest.getRequestURI();
            String HOST_IP = servletRequest.getRemoteAddr();
            if (checkOpenURL(URI)) {
                logger.info(LogPurpose.IGNORE_OPEN_URL + HOST_IP);
            } else {
                String token = getToken(servletRequest);
                ValidateTokenDTO tokenDTO = tokenManager.validateToken(token);
                if (tokenDTO.getStatus()) {
                    String username = tokenDTO.getSubject();
                    if (doUseBucket) {
                        BucketRequest bucketRequest = new BucketRequest();
                        bucketRequest.setToken("Irfan");
                        String uriToken = "http://localhost:8090/api/limiter/verify";
                        RestTemplate restTemplate = new RestTemplate();
                        Object messageResponse = restTemplate.postForObject(uriToken, bucketRequest, Object.class);
//                        Bucket bucket = rateLimiter.resolveBucket(username);
                        Boolean tokenConsumed = (Boolean) ((LinkedHashMap<?, ?>) messageResponse).get("tokenConsume");
                        if (tokenConsumed) {

                        } else
                            throw new TokenException("TOO MANY REQUEST");
                    }
                    UserDetails userDetails = userService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(servletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                } else {
                    throw new TokenException(tokenDTO.getMessage());
                }
            }
        } catch (Exception exception) {
            logger.error(ErrorMessage.INTERNAL_FILTER_FAILED + exception.getMessage());
            throw new TokenException(exception.getMessage());
        } finally {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private Boolean checkOpenURL(String uri) {
        boolean check = Boolean.FALSE;
        for (String url : ServletVariable.TOKEN_FILTER_OPEN_URLS) {
            check = uri.contains(url);
            if (check)
                break;
        }
        return check;
    }

    private String getToken(HttpServletRequest httpServletRequest) {
        String requestHeader = httpServletRequest.getHeader(JwtVariable.SERVLET_REQUEST_HEADER);

        if (StringUtils.hasText(requestHeader) && requestHeader.startsWith(JwtVariable.TOKEN_PREFIX)) {
            return requestHeader.substring(JwtVariable.TOKEN_SUBSTRING_INDEX);
        }

        throw new TokenException(ErrorMessage.TOKEN_NOT_FOUND);
    }
}

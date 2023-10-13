package com.topic.module.userManagement.security.filter;


import com.topic.exception.CommonException;
import com.topic.module.userManagement.model.security.ValidateToken;
import com.topic.module.userManagement.security.limiter.TokenManager;
import com.topic.module.userManagement.service.UserService;
import com.topic.module.userManagement.utility.constant.JwtVariable;
import com.topic.module.userManagement.utility.constant.ServletVariable;
import com.topic.module.userManagement.utility.message.ErrorMessage;
import com.topic.module.userManagement.utility.message.LogPurpose;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Collections;

public class AuthenticationTokenFilter extends AuthenticationFilter {
    private final UserService userService;
    private final TokenManager tokenManager;

    public AuthenticationTokenFilter(UserService userService, TokenManager tokenManager) {
        super(
                new ProviderManager(Collections.singletonList(new DaoAuthenticationProvider())),
                new BasicAuthenticationConverter()
        );
        this.userService = userService;
        this.tokenManager = tokenManager;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            String URI = servletRequest.getRequestURI();
            String HOST_IP = servletRequest.getRemoteAddr();
            if (checkOpenURL(URI)) {
                logger.info(LogPurpose.IGNORE_OPEN_URL + HOST_IP);
            } else {
                String token = getToken(servletRequest);
                ValidateToken validateToken = tokenManager.validateToken(token);
                if (validateToken.getStatus()) {
                    String username = validateToken.getSubject();
                    UserDetails userDetails = userService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(servletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    throw new CommonException(validateToken.getMessage());
                }
            }
        } catch (Exception exception) {
            logger.error(ErrorMessage.INTERNAL_FILTER_FAILED + exception.getMessage());
            throw new CommonException(exception.getMessage());
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

        throw new CommonException(ErrorMessage.TOKEN_NOT_FOUND);
    }
}

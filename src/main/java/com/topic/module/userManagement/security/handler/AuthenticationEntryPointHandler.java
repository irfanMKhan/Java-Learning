package com.topic.module.userManagement.security.handler;


import com.topic.module.userManagement.utility.constant.ServletVariable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint {

    private final LoginAttemptHandler loginAttemptHandler;

    @Override
    public void commence(HttpServletRequest servletRequest,
                         HttpServletResponse servletResponse,
                         AuthenticationException exception) throws IOException, ServletException {

        log.error(exception.toString());

        loginAttemptHandler.loginFailed(servletRequest);

        servletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, ServletVariable.SERVLET_MESSAGE);
        servletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        servletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
    }


}

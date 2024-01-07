package com.topic.module.userManagement.controller;

import com.topic.exception.CommonException;
import com.topic.module.userManagement.model.payload.request.LoginRequest;
import com.topic.module.userManagement.model.payload.response.MessageResponse;
import com.topic.module.userManagement.model.payload.response.TokenResponse;
import com.topic.module.userManagement.security.handler.LoginAttemptHandler;
import com.topic.module.userManagement.security.limiter.TokenManager;
import com.topic.module.userManagement.utility.logger.ApplicationLogger;
import com.topic.module.userManagement.utility.message.CommonMessage;
import com.topic.module.userManagement.utility.message.ErrorMessage;
import com.topic.module.userManagement.utility.message.LogPurpose;
import com.topic.module.userManagement.utility.route.RouteInformation;
import com.topic.module.userManagement.utility.type.Enum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(RouteInformation.AUTHENTICATION_ROUTE)
public class AuthenticationRestController {


    private final TokenManager tokenManager;

    private final LoginAttemptHandler loginHandler;

    private final AuthenticationManager authenticationManager;

    @PostMapping(RouteInformation.REGISTRATION_ROUTE)
    public ResponseEntity<?> createAccount(@RequestBody @Valid LoginRequest requestDTO) throws Exception {
        ApplicationLogger.logInfo(Enum.LogType.REQUEST, LogPurpose.REGISTER_ACCOUNT, requestDTO);



        ApplicationLogger.logInfo(Enum.LogType.RESPONSE, LogPurpose.REGISTER_ACCOUNT, CommonMessage.USER_CREATED);
        return new ResponseEntity<>(new MessageResponse<>(CommonMessage.USER_CREATED, null), HttpStatus.CREATED);
    }

    @PostMapping(RouteInformation.SIGN_IN_ROUTE)
    public ResponseEntity<?> getToken(@RequestBody @Valid LoginRequest requestDTO, HttpServletRequest servletRequest) {
        ApplicationLogger.logInfo(Enum.LogType.REQUEST, LogPurpose.SIGN_IN, requestDTO);

        if (loginHandler.isBlocked(servletRequest)) {
            throw new CommonException(ErrorMessage.USER_IP_BLOCK);
        } else {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestDTO.getUsername(), requestDTO.getPassword()));

            String token = tokenManager.generateToken(authentication);

            ApplicationLogger.logInfo(Enum.LogType.RESPONSE, LogPurpose.SIGN_IN, CommonMessage.TOKEN_GENERATED);
            return ResponseEntity.ok(new TokenResponse(token));
        }
    }

    @PostMapping(RouteInformation.CHANGE_PASSWORD_ROUTE)
    public ResponseEntity<?> changePassword(@RequestBody @Valid LoginRequest requestDTO) throws Exception {
        ApplicationLogger.logInfo(Enum.LogType.REQUEST, LogPurpose.CHANGE_PASSWORD, requestDTO);



        if (true) {

            ApplicationLogger.logInfo(Enum.LogType.RESPONSE, LogPurpose.CHANGE_PASSWORD, CommonMessage.PASSWORD_CHANGED);
            return new ResponseEntity<>(new MessageResponse<>(CommonMessage.PASSWORD_CHANGED, null), HttpStatus.ACCEPTED);
        } else
            throw new CommonException(ErrorMessage.BAD_CREDENTIAL);
    }

}

package com.topic.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException exception) {
        log.error(exception.toString(), exception);
        return new ResponseEntity<>("ACCESS DENIED", HttpStatus.FORBIDDEN);
    }

    @ResponseBody
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<?> handleSQLException(SQLException exception) {
        log.error(exception.toString(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<?> handleInternalServerException(HttpServerErrorException.InternalServerError exception) {
        log.error(exception.toString(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception) {
        log.error(exception.toString(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(CommonMessageException.class)
    public ResponseEntity<?> handleCommonException(CommonMessageException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(CommonStatusException.class)
    public ResponseEntity<?> handleAuthenticationException(CommonStatusException exception,
                                                           HttpServletRequest request,
                                                           HttpServletResponse response) {
        log.error("status ::" + response.getStatus() + " -> reason :: " + exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatusCode.valueOf(response.getStatus()));
    }

}

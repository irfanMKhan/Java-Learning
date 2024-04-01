package com.topic.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class CommonStatusException extends ResponseStatusException {

    public CommonStatusException(HttpStatusCode status) {
        super(status);
    }

    public CommonStatusException(HttpStatusCode status, String reason) {
        super(status, reason);
    }

    public CommonStatusException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }

    public CommonStatusException(HttpStatusCode status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    protected CommonStatusException(HttpStatusCode status, String reason, Throwable cause,
                                    String messageDetailCode, Object[] messageDetailArguments) {
        super(status, reason, cause, messageDetailCode, messageDetailArguments);
    }

}

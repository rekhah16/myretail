package com.myretail.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR )
public class MyRetailException extends RuntimeException{

    public MyRetailException() {
        super();
    }

    public MyRetailException(String message) {
        super(message);
    }

    public MyRetailException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyRetailException(Throwable cause) {
        super(cause);
    }

    protected MyRetailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

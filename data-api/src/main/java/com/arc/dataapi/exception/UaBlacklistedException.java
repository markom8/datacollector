package com.arc.dataapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User Agent is blacklisted!")
public class UaBlacklistedException extends Exception {


    private static final long serialVersionUID = 9115230446702566553L;

    public UaBlacklistedException(String message) {
        super(message);
    }
}

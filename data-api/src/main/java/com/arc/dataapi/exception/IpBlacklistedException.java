package com.arc.dataapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Ip is blacklisted!")
public class IpBlacklistedException extends Exception{

    private static final long serialVersionUID = 4646996102468838763L;

    public IpBlacklistedException(String message) {
        super(message);
    }
}

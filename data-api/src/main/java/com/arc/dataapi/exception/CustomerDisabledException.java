package com.arc.dataapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Customer is diabled!")
public class CustomerDisabledException extends Exception{

    private static final long serialVersionUID = -5252190095522415918L;

    public CustomerDisabledException(String message) {
        super(message);
    }
}

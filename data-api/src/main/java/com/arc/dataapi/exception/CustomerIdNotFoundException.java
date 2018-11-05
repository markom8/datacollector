package com.arc.dataapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Client not found!")
public class CustomerIdNotFoundException extends Exception{


    private static final long serialVersionUID = 3984779847360449330L;

    public CustomerIdNotFoundException(String message) {
        super(message);
    }
}

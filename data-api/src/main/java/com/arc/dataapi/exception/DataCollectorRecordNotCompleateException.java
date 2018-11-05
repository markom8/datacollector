package com.arc.dataapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Request body not complete!")
public class DataCollectorRecordNotCompleateException extends Exception{

    private static final long serialVersionUID = -4678322727701391510L;

    public DataCollectorRecordNotCompleateException(String message) {
        super(message);
    }
}

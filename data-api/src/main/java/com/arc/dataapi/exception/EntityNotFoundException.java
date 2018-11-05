package com.arc.dataapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Could not find entity with id.")
public class EntityNotFoundException extends Exception
{

    private static final long serialVersionUID = 8982688818693245120L;

    public EntityNotFoundException(String message)
    {
        super(message);
    }

}

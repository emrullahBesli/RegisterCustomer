package com.besli.register.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GetCustomerByPhoneNumberException  extends RuntimeException{
    public GetCustomerByPhoneNumberException(String message) {
        super(message);
    }
}

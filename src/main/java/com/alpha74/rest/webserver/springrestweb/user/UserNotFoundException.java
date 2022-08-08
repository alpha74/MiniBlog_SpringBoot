package com.alpha74.rest.webserver.springrestweb.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
    Using @ResponseStatus set to 404, we are explicitly telling server to reutnr 404 code.
    Else it will return 500 error.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}

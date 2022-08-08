package com.alpha74.rest.webserver.springrestweb.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/*
    This class is for standardizing the exception response across Org.

    Note that: exception response will contain only these params, and
     no params which were present by default.
 */

public class ExceptionResponse
{
    private Date timestamp ;
    private String message ;
    private String details ;

    public ExceptionResponse(Date timestamp, String message, String details)
    {
        super() ;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public String getMessage()
    {
        return message;
    }

    public String getDetails()
    {
        return details;
    }
}

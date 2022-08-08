package com.alpha74.rest.webserver.springrestweb.exception;

import com.alpha74.rest.webserver.springrestweb.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/*
    ResponseEntityExceptionHandler is the default class in Spring for handling exceptions.

    - @ControllerAdvice makes this class available in all other Controllers/Resources for usage.
 */

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
    /*
        This method is copied from ResponseEntityExceptionHandler and must have this func signature.

        This method handles all exceptions and returns 500 Error code.
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions
        (Exception ex, WebRequest request) throws Exception
    {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity( exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR) ;
    }

    /*
        Handling for UserNotFound exception.
     */
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException
            (Exception ex, WebRequest request) throws Exception
    {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity( exceptionResponse, HttpStatus.NOT_FOUND) ;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(), "Validation Failed", ex.getBindingResult().toString()) ;

        return new ResponseEntity( exceptionResponse, HttpStatus.BAD_REQUEST) ;
    }
}

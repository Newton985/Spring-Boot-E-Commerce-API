package com.newtonic.SpringShop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * TODO: write you class description here
 *
 * @author Newton
 */

@ControllerAdvice
public class AuthFailureAdvice {

    @ResponseBody
    @ExceptionHandler(AuthFailureException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)

    String authFailureHandler(AuthFailureException e){
        return new AppException(e.getMessage()).toString();
    }
}

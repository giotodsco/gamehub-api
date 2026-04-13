package com.todesco.gamehub.config;

import com.todesco.gamehub.exception.UserNameOrPasswordInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AplicationControllerAdvice {


    @ExceptionHandler(UserNameOrPasswordInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notFoundException(UserNameOrPasswordInvalidException ex){
        return ex.getMessage();
    }

}

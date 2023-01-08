package net.exceptionhandler.exceptionhandlerdemo.advice;


import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class UserExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public List<String> invalidArgument(ConstraintViolationException ex){

        List<String> list = new ArrayList<>();

        ex.getConstraintViolations().forEach(error->list.add(String.valueOf(ex.getLocalizedMessage())));
        return list;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> businessException(UserNotFoundException ex){
        Map<String,String> map = new HashMap<>();
        map.put("error message", ex.getMessage());

        return map;
    }
}

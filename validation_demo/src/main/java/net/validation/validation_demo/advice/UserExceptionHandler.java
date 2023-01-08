package net.validation.validation_demo.advice;


import net.validation.validation_demo.exception.UserNorFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArguments(MethodArgumentNotValidException ex){

        Map<String,String> errorMap= new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error->{
                    errorMap.put(error.getField(), error.getDefaultMessage());});

        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNorFoundException.class)
    public Map<String,String> handleBusinessException(UserNorFoundException ex){

        Map<String,String> errorMap= new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());

        return errorMap;
    }
}

package com.transactional.transactionalexample.exception;

public class InsufficientAmount extends RuntimeException{
    public InsufficientAmount(String message){
        super(message);
    }
}

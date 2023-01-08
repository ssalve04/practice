package net.exceptionhandler.exceptionhandlerdemo.advice;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String message) {
        super(message);
    }
}

package com.chase.exceptions;

public class BalanceNotSufficientException extends RuntimeException{
    public BalanceNotSufficientException(String message){
        super(message);
    }
}

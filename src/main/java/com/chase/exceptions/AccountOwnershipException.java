package com.chase.exceptions;

public class AccountOwnershipException extends RuntimeException {
    public AccountOwnershipException(String message) {
        super(message);
    }
}

package com.example.kycapp2.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {

        super(message);
    }
}

package com.company.U2M3Summative.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(){

    }

    public NotFoundException(String message){
        super(message);
    }
}

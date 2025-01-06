package com.lcwd.hotel.exception;

public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String ex){
        super(ex);
    }

    public ResourceNotFoundException(){
        super("resource nit found");
    }

}

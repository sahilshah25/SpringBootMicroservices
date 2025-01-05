package com.lcwd.userservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    //extra properties which want to manage
    public ResourceNotFoundException(){
        super("Resource Not Found on server");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }

}

package com.org.PropertyService.Exception;


public class PropertyNotFound extends RuntimeException{

    public PropertyNotFound(String message){
        super(message);
    }
}

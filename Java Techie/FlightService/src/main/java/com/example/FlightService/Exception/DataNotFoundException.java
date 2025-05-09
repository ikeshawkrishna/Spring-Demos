package com.example.FlightService.Exception;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(String msg){
        super(msg);
    }
}

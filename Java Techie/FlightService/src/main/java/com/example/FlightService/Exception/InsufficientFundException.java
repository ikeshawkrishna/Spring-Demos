package com.example.FlightService.Exception;

public class InsufficientFundException extends RuntimeException{

    public InsufficientFundException(String msg){
        super(msg);
    }
}

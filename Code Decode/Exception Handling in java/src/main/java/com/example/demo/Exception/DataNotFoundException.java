package com.example.demo.Exception;

import org.springframework.stereotype.Component;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(String msg){
        super(msg);
    }
}

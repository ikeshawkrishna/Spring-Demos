package com.project.Student.Exceptions;

public class UserAlreadyExistException extends Exception{

    public UserAlreadyExistException(String errorMessage){
        super(errorMessage);
    }
}

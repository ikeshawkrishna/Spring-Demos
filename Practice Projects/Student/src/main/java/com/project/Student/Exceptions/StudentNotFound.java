package com.project.Student.Exceptions;

import lombok.Data;
import org.springframework.stereotype.Component;

public class StudentNotFound extends Exception {

    public StudentNotFound(String errorMessage) {
        super(errorMessage);
    }
}

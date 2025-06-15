package com.org.PropertyService.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationExceptionResponse {
    private int code;
    private Object respObject;
}

package com.project.Student.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogingAspect {

    @Before("execution(* com.project.Student.Controller.BookController.getAllBooks(..))")
    public void log_Before(){
        System.out.println("Before log has been printed...");
    }

    @After("execution(* com.project.Student.Controller.BookController.getAllBooks(..))")
    public void log_After(){
        System.out.println("After log has been printed...");
    }
}

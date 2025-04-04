package com.example.Security.Demo;

import java.io.IOException;

interface A{
    static void show(){
        System.out.println("In A Show");
    }
}
class B implements A{
    static void show(){
        System.out.println("In B Show");
    }
}

public class Test {
    public static void main(String[] args) {
        A obj = new B();
        A.show();
    }

    void shoe(){
        
    }
}



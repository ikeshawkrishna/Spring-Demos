package com.example.Security.Controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Hidden
public class AnotherController {

    @GetMapping("/getscore")
    public String getSCore(){
        return "100%";
    }
}

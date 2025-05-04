package com.example.Security;

import com.example.Security.Service.JwtService;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.util.Arrays;
import java.util.Base64;

public class DemoRunClass {

    public static void main(String[] args) {
//        JwtService jwtService = new JwtService();

        String name = "Keshaw";
        String encodedString = Base64.getEncoder().encodeToString(name.getBytes());

        byte[] decode = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decode);
        System.out.println(decodedString);;
    }
}

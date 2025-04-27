package com.example.Security.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.*;


@Service
public class JwtService {

    private String secretKet;

    public JwtService(){
        this.secretKet = generateSecretKey();
    }

    public String generateToken(String username) {
        Map<String, Objects> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        byte[] keybytes = Decoders.BASE64.decode(secretKet);
        return Keys.hmacShaKeyFor(keybytes);
    }

    private String generateSecretKey(){
        try{
            KeyGenerator keygen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keygen.generateKey();
            System.out.println("secretKey >> " + Base64.getEncoder().encodeToString(secretKey.getEncoded()));
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (Exception e){
            throw new RuntimeException("error in generating key " + e);
        }
    }
}

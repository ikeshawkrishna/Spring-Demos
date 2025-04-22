package com.example.Security.Service;

import com.example.Security.Entity.Users;
import com.example.Security.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistryService {
    @Autowired
    UserRepo userRepo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users userRegistry(Users user){

        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return userRepo.save(user);
    }
}

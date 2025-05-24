package com.project.Student.Service;

import com.project.Student.Exceptions.UserAlreadyExistException;
import com.project.Student.Model.User;
import com.project.Student.Repo.UserRepo;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    BCryptPasswordEncoder encoder;

    public User userRegistry(User user) throws Exception{
        User byUsername = userRepo.findByUsername(user.getUsername());
        if(byUsername != null){
            throw new UserAlreadyExistException("User already Exist !! ");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    //we have setted the TTL in rediscachemanager configurations.

    @Cacheable(value = "OTPCache", key = "#session")
    public String generateOTP(String session) {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // ensures 6-digit number
        return String.valueOf(otp);
    }
}

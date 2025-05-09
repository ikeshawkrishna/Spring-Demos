package com.project.Student.Service;

import com.project.Student.Exceptions.UserAlreadyExistException;
import com.project.Student.Model.User;
import com.project.Student.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
}

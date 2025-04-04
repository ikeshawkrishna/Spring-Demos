package com.example.Security.Service;

import com.example.Security.Model.UserPrincipal;
import com.example.Security.Entity.Users;
import com.example.Security.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found 404");
        }

        return new UserPrincipal(user);
    }
}

package com.project.Student.Controller;

import com.project.Student.Exceptions.ErrorResponse;
import com.project.Student.Model.User;
import com.project.Student.Service.JWTService;
import com.project.Student.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @PostMapping("/userRegistry")
    public ResponseEntity<?> userRegistry(@RequestBody User user){
        User user1 = null;
        try {
            user1  = userService.userRegistry(user);
        } catch (Exception e) {
            return new ResponseEntity<ErrorResponse>(
                    new ErrorResponse("101", e.getMessage()), HttpStatus.BAD_REQUEST
            );
        }
        return ResponseEntity.ok(user1);
    }

    @GetMapping("/userLogin")
    public String userLogin(@RequestBody User user){
        Authentication authenticate = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        System.out.println("authenticate >>>> " + authenticate);
        if(authenticate.isAuthenticated()){
            return jwtService.generateToken(user);
        } else {
            return "Failure";
        }
    }
}

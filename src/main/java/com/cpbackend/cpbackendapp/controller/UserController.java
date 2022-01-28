package com.cpbackend.cpbackendapp.controller;

import com.cpbackend.cpbackendapp.model.User;
import com.cpbackend.cpbackendapp.model.request.LoginRequest;
import com.cpbackend.cpbackendapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin
@RestController
@RequestMapping(path = "/auth/users")
public class UserController {

    private UserService userService;
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //to register a user
    //http://localhost:9092/auth/users/register
    @PostMapping("/register")
    public User createUser(@RequestBody User userObject){
        LOGGER.info("calling createUser method from controller");
        return userService.createUser(userObject);
    }

    //to login a user
    //http://localhost:9092/auth/users/login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        LOGGER.info("calling loginUser method from user controller");
        return userService.loginUser(loginRequest);
    }

    //to check if user is logged in
    //http://localhost:9092/auth/users/isloggedin
    @GetMapping("/isloggedin")
    public User isLoggedIn(){
        LOGGER.info("calling isLoggedIn method from user controller");
        return userService.isLoggedIn();
    }
}
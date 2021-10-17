package com.cgi.foodie.controller;

import com.cgi.foodie.model.User;
import com.cgi.foodie.model.UserAuth;
import com.cgi.foodie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        if(savedUser == null) {
            // http status 403 if user tries to register with same emailId
            return new ResponseEntity<>(new User(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> getUser(@RequestBody UserAuth userAuth) {
        User loggedInUser = userService.getUser(userAuth);

        // if received null object return error response
        if(loggedInUser == null) {
            return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
    }
}
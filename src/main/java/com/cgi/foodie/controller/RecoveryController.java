package com.cgi.foodie.controller;

import com.cgi.foodie.model.Recovery;
import com.cgi.foodie.model.User;
import com.cgi.foodie.service.RecoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/forgot")
public class RecoveryController {

    @Autowired
    RecoveryService recoveryService;

    // when user submit details for verification
    @PostMapping("/change")
    public ResponseEntity<Recovery> checkDetails(@RequestBody Recovery details) {
        Recovery returnedObject = recoveryService.checkDetails(details);
        return new ResponseEntity<>(returnedObject, HttpStatus.OK);
    }


    // when user sends new password
    @PostMapping("/reset")
    public ResponseEntity<User> resetPassword(@RequestBody User updatedUser) {
        User newUser = recoveryService.resetPassword(updatedUser);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
}

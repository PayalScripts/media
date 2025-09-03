package com.social.media.controllers;

import com.social.media.models.SocialUser;
import com.social.media.services.SocialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {
    private Logger log = LoggerFactory.getLogger(SocialController.class);
    @Autowired
    private SocialService socialService;

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getUsers(){
        log.info("Fetching all users");
        return new ResponseEntity<>(socialService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser){
        log.info("Creating a new user: {}", socialUser);
        return new ResponseEntity<>(socialService.saveUser(socialUser), HttpStatus.CREATED);
    }
   /* @PostMapping("/social/users")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser){
        return new ResponseEntity<>(socialService.saveUser(socialUser), HttpStatus.CREATED);
    }*/
    /*@DeleteMapping("/social/users/{userId}")
    public ResponseEntity<SocialUser> deleteUser(@PathVariable Long userId){
        return new ResponseEntity<>(socialService.deleteUser(userId),HttpStatus.OK);
    }*/ @DeleteMapping("/social/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        log.info("Deleting user with ID: {}", userId);
        socialService.deleteUser(userId);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}

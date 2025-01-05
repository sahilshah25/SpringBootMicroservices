package com.lcwd.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.userservice.entities.User;
import com.lcwd.userservice.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

   @Autowired
   private UserServices userServices;


   

    //create 
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println("create handler runs fine");
      User user1 = userServices.saveUser(user);
      return ResponseEntity.status(HttpStatus.CREATED).body(user1);
   }

    //single user get


    @GetMapping("/{userId}")
   public ResponseEntity<User> getSingleUser(@PathVariable String userId){

    User user=userServices.getUser(userId);
    //fetchrating of the above user from rating service

    return ResponseEntity.ok(user);

    }


    //all user get

     @GetMapping
     public ResponseEntity<List<User>> getAllUser(){

      List<User> users= userServices.getAllUser();

      return ResponseEntity.ok(users);



    }

}


package com.lcwd.userservice.services;

import java.util.List;

import com.lcwd.userservice.entities.User;

public interface UserServices {

    //user operations



    //create

    User saveUser(User user);

  //get all user

  List<User> getAllUser();


  //get single user of given userId


  User getUser(String userId);


  User deletUser(String userId);

  User updateUser(String UserId);
     


    

}


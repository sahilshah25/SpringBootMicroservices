package com.lcwd.userservice.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.userservice.entities.Hotel;
import com.lcwd.userservice.entities.Rating;
import com.lcwd.userservice.entities.User;
import com.lcwd.userservice.exceptions.ResourceNotFoundException;
import com.lcwd.userservice.external.services.HotelService;
import com.lcwd.userservice.repositories.UserRepositories;
import com.lcwd.userservice.services.UserServices;

@Service
public class UserImple implements UserServices {

   private Logger  logger=LoggerFactory.getLogger(UserImple.class);

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
     // it generates unique user id
     String randomUserId= UUID.randomUUID().toString();
       user.setUserId(randomUserId);
       return userRepositories.save(user);
    }

    @Override
    public List<User> getAllUser() {
       return userRepositories.findAll();
    }

    @Override
    public User getUser(String userId) {
        
       User user= userRepositories.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user with iven id is not found on server"+userId));



     Rating[]  ratingOfUser= restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
     System.out.println(Arrays.toString(ratingOfUser));

     List<Rating> ratings=Arrays.stream(ratingOfUser).collect(Collectors.toList());
     
     
      List<Rating> ratingList= ratings.stream().map(rating -> {
        // api call to hotel service to get the hotel
       //http://localhost:8082/hotels
        System.out.println("this is my hotel id-------------"+rating.getHotelId());
      //ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
       
      Hotel hotel=hotelService.getHotel(rating.getHotelId());

       logger.info(hotel+"{}");
        //set the hotel to rating

        rating.setHotel(hotel);
        //return the rating

        return rating;

      }).collect(Collectors.toList());



     user.setRating(ratingList);
      

        return user;
    }

    @Override
    public User deletUser(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletUser'");
    }

    @Override
    public User updateUser(String UserId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

}


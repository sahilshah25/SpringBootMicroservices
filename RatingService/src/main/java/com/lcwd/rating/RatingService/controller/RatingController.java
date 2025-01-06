package com.lcwd.rating.RatingService.controller;

import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.services.RatingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@RestController

@RequestMapping("/ratings")

public class RatingController {

@Autowired
    private  RatingService ratingService;

    //create rating
  @PostMapping
 public ResponseEntity<Rating> create(@RequestBody Rating rating){

    Rating rating1=ratingService.createRating(rating);

    return ResponseEntity.status(HttpStatus.CREATED).body(rating1);

   }

// get all rating
@GetMapping
public ResponseEntity<List<Rating>> getAllRatings(){
    List<Rating> ratings=ratingService.getRatings();

    return ResponseEntity.ok(ratings);
}


// get by user id
@GetMapping("/users/{userId}")
public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
    List<Rating> ratings=ratingService.getRatingsByUserId(userId);

    return ResponseEntity.ok(ratings);
}



// get by hotel id

@GetMapping("/hotels/{hotelId}")
public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
    List<Rating> ratings=ratingService.getRatingByHotelId(hotelId);

    return ResponseEntity.ok(ratings);
}



}

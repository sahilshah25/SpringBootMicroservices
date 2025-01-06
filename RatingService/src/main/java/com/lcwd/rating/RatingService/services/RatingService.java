package com.lcwd.rating.RatingService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.repo.ratingRepo;
@Service
public interface RatingService  {





//create

 Rating createRating(Rating rating);

//get all ratings

List<Rating> getRatings();

//get all by  user id

List<Rating> getRatingsByUserId(String UserId);

//get all by hotels

List<Rating> getRatingByHotelId(String HotelId);


}

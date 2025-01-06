package com.lcwd.rating.RatingService.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.rating.RatingService.entities.Rating;
@Repository
public interface ratingRepo extends MongoRepository<Rating,String> {


    //write custom queries here


    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);






}

package com.lcwd.rating.RatingService.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.repo.ratingRepo;
import com.lcwd.rating.RatingService.services.RatingService;

@Service
public class RatingServiceImple implements RatingService{

   private final ratingRepo ratingrepo;
    @Autowired
    public RatingServiceImple(ratingRepo ratingRepo) {
        this.ratingrepo = ratingRepo;
    }


    @Override
    public Rating createRating( Rating rating) {
     return ratingrepo.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
       
      return ratingrepo.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String UserId) {
        return ratingrepo.findByUserId(UserId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String HotelId) {
       return ratingrepo.findByHotelId(HotelId);
    }
}
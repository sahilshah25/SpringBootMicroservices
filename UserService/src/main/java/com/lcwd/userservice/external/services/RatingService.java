package com.lcwd.userservice.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.lcwd.userservice.entities.Rating;

@FeignClient(name="RATINGSERVICE")
public interface RatingService {
     

    @PostMapping("ratings")
    Rating createRating(Rating values);



}

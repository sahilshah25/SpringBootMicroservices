package com.lcwd.hotel.services;

import java.util.List;

import com.lcwd.hotel.entities.Hotel;

public interface hotelService {

    //create

   Hotel create(Hotel hotel);
    

   //get all
   List<Hotel> getAll();

   //getsingle


   Hotel get(String id);


}

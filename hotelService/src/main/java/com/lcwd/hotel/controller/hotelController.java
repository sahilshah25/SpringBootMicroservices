package com.lcwd.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.services.hotelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/hotels")
public class hotelController {

    @Autowired
    private hotelService hotelService;


    //create api

   @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

     return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));



  }

    // get single api

    @GetMapping("/{hotelId}")
   public ResponseEntity<Hotel>  getHotel(@PathVariable String hotelId){

   Hotel hotel=hotelService.get(hotelId);

     return ResponseEntity.status(HttpStatus.OK).body(hotel);



  }


    //get all api

    @GetMapping
    public ResponseEntity<List<Hotel>>  getAllHotel(){
 
        List<Hotel> hotels= hotelService.getAll();
 
      return ResponseEntity.status(HttpStatus.OK).body(hotels);
 
 
 
   }




}

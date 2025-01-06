package com.lcwd.hotel.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exception.ResourceNotFoundException;
import com.lcwd.hotel.repositories.HotalRepositories;
import com.lcwd.hotel.services.hotelService;

@Service
public class hotelServiceimpl implements hotelService {

     @Autowired
    private HotalRepositories hotelRepositories;

    @Override
    public Hotel create(Hotel hotel) {
        String id=UUID.randomUUID().toString();
        hotel.setId(id);
        return   hotelRepositories.save(hotel);
       
    }

    @Override
    public List<Hotel> getAll() {
        
        return hotelRepositories.findAll();
    }

    @Override
    public Hotel get(String id) {
       
        return hotelRepositories.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with given id not found"));
    }



}

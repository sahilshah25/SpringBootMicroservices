package com.lcwd.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.hotel.entities.Hotel;

@Repository
public interface HotalRepositories extends JpaRepository<Hotel,String> {

    //

}

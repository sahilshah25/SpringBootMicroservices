package com.lcwd.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.userservice.entities.User;

@Repository
public interface UserRepositories extends JpaRepository<User,String> {


//we write custom query method
//write here

}

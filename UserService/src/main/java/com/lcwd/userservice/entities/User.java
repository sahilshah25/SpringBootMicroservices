package com.lcwd.userservice.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="user")


public class User {

    @Id
    
   
    private String userId;

   @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="about")
    private String about;

    //other user properties that we want


    @Transient
    private List<Rating> rating=new ArrayList<>();
     }

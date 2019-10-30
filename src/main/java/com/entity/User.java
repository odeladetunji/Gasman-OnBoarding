package com.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    public Long Id;

//    @Column(name = "username")
//    public String username;
//
//    @Column(name = "password")
//    public String password;

    @Column(name = "fullname")
    public String fullname;

    public User(){}

}

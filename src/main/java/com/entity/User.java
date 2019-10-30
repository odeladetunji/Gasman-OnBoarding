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

    @JsonProperty("username")
    public String username;

    @JsonProperty("password")
    public String password;

    public User(){}

}
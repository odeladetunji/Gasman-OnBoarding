package com.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authentication")
public class Authentication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    public Authentication(){}

}

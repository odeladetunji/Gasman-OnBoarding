package com.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authentication")
public class Authentication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    public Long Id;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "distributor_Id", referencedColumnName = "Id", unique = true)
    public Distributors distributors;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "Id", unique = true)
    public User user;

    public Authentication(){}

}



























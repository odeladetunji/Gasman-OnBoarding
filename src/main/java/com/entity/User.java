package com.entity;


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

    @Column(name = "fullname")
    public String fullname;

    @OneToOne (mappedBy = "user")
    public Authentication authentication;

    public User(){}


}



























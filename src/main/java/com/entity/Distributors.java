package com.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "distributors")
public class Distributors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;

    @Column(name = "fullname")
    public String fullname;

    @Column(name = "photographID")
    public String photographId;

    @Column(name = "phone_number")
    public Long phoneNumber;

    @Column(name = "means_of_delivery")
    public String meansOfDelivery;

    @Column(name = "shop_address")
    public String shopAddress;

    @Column(name = "location_on_map")
    public String LocationOnMap;

    public Distributors(){}
}

package com.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "distributors")
public class Distributors {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
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

    @Column(name = "localGovernment")
    public String localGovernment;

    @Column(name = "city_or_state")
    public String cityStateOfDistributor;

    @Column(name = "location_on_map")
    public String LocationOnMap;

    @OneToOne (mappedBy = "distributors")
    public Authentication authentication;

    public Distributors(){}

}

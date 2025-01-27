package com.sigma.DTO;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;



@Data
public class SaloonDTO {

    private Long id;

    private String name;

    private List<String> images;

    private String address;

    private String phoneNumber;

    private String city;
    private String email;


    private Long ownerId;




    private LocalTime openTime;

    private LocalTime closeTime;
}

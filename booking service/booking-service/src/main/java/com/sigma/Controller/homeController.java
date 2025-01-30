package com.sigma.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {


    @GetMapping("")
    public String HomeControllerHandler() {
        return "Booking Microservice for saloon booking system";
    }
}

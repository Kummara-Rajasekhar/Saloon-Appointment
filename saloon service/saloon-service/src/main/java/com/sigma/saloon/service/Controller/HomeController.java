package com.sigma.saloon.service.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("")
    public String HomeControllerHandler() {
        return "Saloon Microservice for saloon booking system";
    }
}

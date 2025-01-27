package com.sigma.Model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
public class ServiceOffering {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int duration;
    @Column(nullable = false)
    private Long saloonId;
    @Column(nullable = false)
    private Long categoryId;
    private String image;
}

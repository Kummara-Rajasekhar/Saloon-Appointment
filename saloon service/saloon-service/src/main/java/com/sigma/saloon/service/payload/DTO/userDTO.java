package com.sigma.saloon.service.payload.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userDTO {

    private Long id;
    private String fullName;
    private String email;
}

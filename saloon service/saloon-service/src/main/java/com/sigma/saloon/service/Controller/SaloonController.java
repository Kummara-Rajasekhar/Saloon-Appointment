package com.sigma.saloon.service.Controller;


import com.sigma.saloon.service.Model.Saloon;
import com.sigma.saloon.service.Service.SaloonService;
import com.sigma.saloon.service.payload.DTO.SaloonDTO;
import com.sigma.saloon.service.payload.DTO.userDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/saloons")
@RequiredArgsConstructor
public class SaloonController {


    private final SaloonService saloonService;


    public ResponseEntity<SaloonDTO> createSaloon(@RequestBody SaloonDTO saloonDTO) {
        userDTO userdto=new userDTO();
        userdto.setId(1L);
        Saloon saloom= saloonService.createSaloon(saloonDTO,userdto);

    }
}

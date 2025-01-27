package com.sigma.saloon.service.Controller;


import com.sigma.saloon.service.Model.Saloon;
import com.sigma.saloon.service.Service.SaloonService;
import com.sigma.saloon.service.mapper.SaloonMapper;
import com.sigma.saloon.service.payload.DTO.SaloonDTO;
import com.sigma.saloon.service.payload.DTO.userDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saloons")
@RequiredArgsConstructor
public class SaloonController {


    private final SaloonService saloonService;




    @PostMapping
    public ResponseEntity<SaloonDTO> createSaloon(@RequestBody SaloonDTO saloonDTO) {
        userDTO userdto=new userDTO();
        userdto.setId(1L);
        Saloon saloon= saloonService.createSaloon(saloonDTO,userdto);
        SaloonDTO saloonDTO1= SaloonMapper.MaptoSaloon(saloon);
        return ResponseEntity.ok(saloonDTO1);
    }

    @PatchMapping("/{saloonId}")
    public ResponseEntity<SaloonDTO> updateSaloon(@PathVariable Long saloonId,@RequestBody SaloonDTO saloonDTO) throws Exception {
        userDTO userdto=new userDTO();
        userdto.setId(1L);
        Saloon saloon= saloonService.updateSaloon(saloonDTO,userdto,saloonId);
        SaloonDTO saloonDTO1= SaloonMapper.MaptoSaloon(saloon);
        return ResponseEntity.ok(saloonDTO1);
    }


    @GetMapping()
    public ResponseEntity<List<SaloonDTO>> getSaloons(@PathVariable Long saloonId,@RequestBody SaloonDTO saloonDTO) throws Exception {

        List<Saloon> saloons= saloonService.getSaloons();
        List<SaloonDTO> saloonDTOs=saloons.stream().map((saloon)->{
            SaloonDTO saloonDTO1= SaloonMapper.MaptoSaloon(saloon);
            return saloonDTO1;

        }).toList();
        return ResponseEntity.ok(saloonDTOs);
    }


    @GetMapping("/{saloonId}")
    public ResponseEntity<SaloonDTO> getSaloonById(@PathVariable Long saloonId) throws Exception {

        Saloon saloon= saloonService.getSaloonById(saloonId);
        SaloonDTO saloonDTO= SaloonMapper.MaptoSaloon(saloon);

        return ResponseEntity.ok(saloonDTO);
    }


    @GetMapping("/search")
    public ResponseEntity<List<SaloonDTO>> searchSaloons(@RequestParam("city") String city) throws Exception {

        List<Saloon> saloons= saloonService.searchSaloonByCity(city);
        List<SaloonDTO> saloonDTOs=saloons.stream().map((saloon)->{
            SaloonDTO saloonDTO1= SaloonMapper.MaptoSaloon(saloon);
            return saloonDTO1;

        }).toList();
        return ResponseEntity.ok(saloonDTOs);
    }


    @GetMapping("/owner")
    public ResponseEntity<SaloonDTO> getSaloonByOwnerId(@PathVariable Long saloonId) throws Exception {
        userDTO userdto=new userDTO();
        userdto.setId(1L);
        Saloon saloon= saloonService.getSaloonByOwnerId(userdto.getId());
        SaloonDTO saloonDTO= SaloonMapper.MaptoSaloon(saloon);

        return ResponseEntity.ok(saloonDTO);
    }
}

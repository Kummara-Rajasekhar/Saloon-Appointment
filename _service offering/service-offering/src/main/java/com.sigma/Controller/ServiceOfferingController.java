package com.sigma.Controller;


import com.sigma.Model.ServiceOffering;
import com.sigma.Service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/service-offering")
@RequiredArgsConstructor
public class ServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    @GetMapping("/saloon/{saloonId}")
    public ResponseEntity<Set<ServiceOffering>> getServiceBySaloonId(@PathVariable Long saloonId, @RequestParam(required = false) Long categoryId){
        Set<ServiceOffering> serviceOfferings=serviceOfferingService.getAllServiceBySaloonId(saloonId,categoryId);
        return new ResponseEntity<>(serviceOfferings, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<ServiceOfferingService>> getServiceById(@PathVariable Long saloonId) throws Exception {
        Optional<ServiceOfferingService> serviceOfferings=serviceOfferingService.getServiceById(saloonId);
        return new ResponseEntity<>(serviceOfferings, HttpStatus.OK);
    }

    @GetMapping("/list/{ids}")
    public ResponseEntity<Set<ServiceOffering>> getServiceByIds(@PathVariable Set<Long> ids){
        Set<ServiceOffering> serviceOfferings=serviceOfferingService.getServicesByIds(ids);
        return new ResponseEntity<>(serviceOfferings, HttpStatus.OK);
    }
}



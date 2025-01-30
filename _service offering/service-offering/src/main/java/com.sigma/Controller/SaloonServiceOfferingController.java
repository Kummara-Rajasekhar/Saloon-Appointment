package com.sigma.Controller;

import com.sigma.DTO.CategoryDTO;
import com.sigma.DTO.SaloonDTO;
import com.sigma.DTO.ServiceDTO;
import com.sigma.Model.ServiceOffering;
import com.sigma.Service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/service-offering/saloon-owner")
@RequiredArgsConstructor
public class SaloonServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    @PostMapping
    public ResponseEntity<ServiceOffering> createService(@RequestBody ServiceDTO serviceDTO){
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1L);
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategoryId());
        ServiceOffering serviceOfferings= (ServiceOffering) serviceOfferingService.createService(saloonDTO,serviceDTO,categoryDTO);
        return new ResponseEntity<>(serviceOfferings, HttpStatus.OK);
    }



    @PostMapping("/{id}")
    public ResponseEntity<ServiceOffering> updateService(@PathVariable Long id,@RequestBody ServiceOffering serviceOffering) throws Exception {

        ServiceOffering serviceOfferings= (ServiceOffering) serviceOfferingService.
                updateService(id,serviceOffering);
        return new ResponseEntity<>(serviceOfferings, HttpStatus.OK);
    }
}

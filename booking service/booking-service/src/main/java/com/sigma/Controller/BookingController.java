package com.sigma.Controller;


import com.sigma.DTO.BookingRequest;
import com.sigma.DTO.SaloonDTO;
import com.sigma.DTO.ServiceDTO;
import com.sigma.DTO.userDTO;
import com.sigma.Model.Booking;
import com.sigma.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;


    @PostMapping()
    public ResponseEntity<Booking> createBooking(@RequestParam Long saloonId, @RequestBody BookingRequest bookingRequest) throws Exception {
        userDTO userdto=new userDTO();
        userdto.setId(1L);
        SaloonDTO saloondto=new SaloonDTO();
        saloondto.setId(saloonId);
        Set<ServiceDTO>  serviceDTOSet=new HashSet<>();
        ServiceDTO serviceDTO=new ServiceDTO();
        serviceDTO.setId(1L);
        serviceDTO.setName("Hait cut for men");
        serviceDTO.setPrice(399);
        serviceDTO.setDuration(45);
        serviceDTOSet.add(serviceDTO);

        Booking booking =bookingService.createBooking(bookingRequest,userdto,saloondto,serviceDTOSet);
        return ResponseEntity.ok(booking);
    }


}

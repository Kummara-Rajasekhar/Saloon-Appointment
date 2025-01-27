package com.sigma.saloon.service.Service;

import com.sigma.saloon.service.Model.Saloon;
import com.sigma.saloon.service.payload.DTO.SaloonDTO;
import com.sigma.saloon.service.payload.DTO.userDTO;

import java.util.List;

public interface SaloonService {
    Saloon createSaloon(SaloonDTO saloon, userDTO user);
    Saloon updateSaloon(SaloonDTO saloon, userDTO user,Long saloonId) throws Exception;
    List<Saloon> getSaloons();
    Saloon getSaloonById(Long id) throws Exception;
    Saloon getSaloonByOwnerId(Long ownerId);
    List<Saloon> searchSaloonByCity(String city);

}

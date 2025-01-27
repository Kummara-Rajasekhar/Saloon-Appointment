package com.sigma.saloon.service.mapper;

import com.sigma.saloon.service.Model.Saloon;
import com.sigma.saloon.service.payload.DTO.SaloonDTO;
import com.sigma.saloon.service.repository.Saloonrepository;
import lombok.RequiredArgsConstructor;



public class SaloonMapper {

    public static SaloonDTO MaptoSaloon(Saloon saloon) {
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(saloon.getId());
        saloonDTO.setName(saloon.getName());
        saloonDTO.setAddress(saloon.getAddress());
        saloonDTO.setCity(saloon.getCity());
        saloonDTO.setImages(saloon.getImages());
        saloonDTO.setOpenTime(saloon.getOpenTime());
        saloonDTO.setCloseTime(saloon.getCloseTime());
        saloonDTO.setPhoneNumber(String.valueOf(saloon.getPhoneNumber()));
        saloonDTO.setOwnerId(saloon.getOwnerId());
        saloonDTO.setEmail(saloon.getEmail());
        return saloonDTO;
    }
}

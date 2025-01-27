package com.sigma.saloon.service.Service.Imp;

import com.sigma.saloon.service.Model.Saloon;
import com.sigma.saloon.service.Service.SaloonService;
import com.sigma.saloon.service.payload.DTO.SaloonDTO;
import com.sigma.saloon.service.payload.DTO.userDTO;
import com.sigma.saloon.service.repository.Saloonrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class SaloonServiceImp implements SaloonService {


    @Autowired
    private final Saloonrepository saloonrepository;
    @Override
    public Saloon createSaloon(SaloonDTO req, userDTO user) {
        Saloon saloon = new Saloon();
        saloon.setName(req.getName());
        saloon.setAddress(req.getAddress());
        saloon.setCity(req.getCity());
        saloon.setImages(req.getImages());
        saloon.setOwnerId(user.getId());
        saloon.setOpenTime(req.getOpenTime());
        saloon.setCloseTime(req.getCloseTime());
        saloon.setPhoneNumber(req.getPhoneNumber());
        return saloonrepository.save(saloon);

    }

    @Override
    public Saloon updateSaloon(SaloonDTO saloon, userDTO user, Long saloonId) throws Exception {
        Saloon saloon1=saloonrepository.findById(saloonId).orElse(null);
        if(saloon1!=null && saloon.getOwnerId().equals(user.getId())) {
            saloon.setName(saloon1.getName());
            saloon.setAddress(saloon1.getAddress());
            saloon.setCity(saloon1.getCity());
            saloon.setImages(saloon1.getImages());
            saloon.setOpenTime(saloon1.getOpenTime());
            saloon.setCloseTime(saloon1.getCloseTime());
            saloon.setPhoneNumber(saloon1.getPhoneNumber());
            saloon1.setOwnerId(user.getId());


        }
        throw new Exception("Saloon not exist");
    }

    @Override
    public List<Saloon> getSaloons() {
        return saloonrepository.findAll();
    }

    @Override
    public Saloon getSaloonById(Long id) throws Exception {
        Saloon saloon=saloonrepository.findById(id).orElse(null);
        if(saloon!=null) {
            return saloon;
        }
        throw new Exception("Saloon not exist");
    }

    @Override
    public Saloon getSaloonByOwnerId(Long ownerId) {
        return saloonrepository.findByOwnerId(ownerId);
    }

    @Override
    public List<Saloon> searchSaloonByCity(String city) {
        return saloonrepository.searchSaloons(city);
    }
}

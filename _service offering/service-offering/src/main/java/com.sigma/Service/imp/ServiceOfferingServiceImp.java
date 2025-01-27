package com.sigma.Service.imp;

import com.sigma.DTO.CategoryDTO;
import com.sigma.DTO.SaloonDTO;
import com.sigma.DTO.ServiceDTO;
import com.sigma.Model.ServiceOffering;
import com.sigma.Service.ServiceOfferingService;
import com.sigma.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ServiceOfferingServiceImp implements ServiceOfferingService {
    private final ServiceRepository serviceRepository;
    @Override
    public ServiceOfferingService createService(SaloonDTO saloonDTO, ServiceDTO serviceDTO, CategoryDTO categoryDTO) {
        ServiceOffering serviceOffering = new ServiceOffering();
        serviceOffering.setImage(serviceDTO.getImage());
        serviceOffering.setSaloonId(saloonDTO.getId());
        serviceOffering.setName(serviceDTO.getName());
        serviceOffering.setDescription(serviceDTO.getDescription());
        serviceOffering.setCategoryId(categoryDTO.getId());
        serviceOffering.setPrice(serviceDTO.getPrice());
        serviceOffering.setDuration(serviceDTO.getDuration());
        return serviceRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception {

        Optional<ServiceOfferingService> serviceOffering= Optional.ofNullable(serviceRepository.findById(serviceId).orElse(null));
        if(serviceOffering==null){
            throw  new Exception("Service not exist with id"+serviceId);
        }
        serviceOffering.setImage(service.getImage());
        serviceOffering.setName(service.getName());
        serviceOffering.setDescription(service.getDescription());
        serviceOffering.setCategoryId(categoryDTO.getId());
        serviceOffering.setPrice(service.getPrice());
        serviceOffering.setDuration(service.getDuration());

        return serviceRepository.save(serviceOffering);
    }

    @Override
    public Set<ServiceOffering> getAllServiceBySaloonId(Long saloonId, Long categoryId) {
        return Set.of();
    }

    @Override
    public Set<ServiceOffering> getServicesByIds(Set<Long> ids) {
        return Set.of();
    }



}

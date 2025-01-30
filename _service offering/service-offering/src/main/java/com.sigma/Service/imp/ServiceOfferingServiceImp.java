package com.sigma.Service.imp;

import com.sigma.DTO.CategoryDTO;
import com.sigma.DTO.SaloonDTO;
import com.sigma.DTO.ServiceDTO;
import com.sigma.Model.ServiceOffering;
import com.sigma.Service.ServiceOfferingService;
import com.sigma.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
        Set<ServiceOffering> services=serviceRepository.findBySaloonId(saloonId);
        if(categoryId!=null){
            services=services.stream().filter(s->s.getCategoryId().equals(categoryId)).collect(Collectors.toSet());

        }
        return services;

    }

    @Override
    public Set<ServiceOffering> getServicesByIds(Set<Long> ids) {
        List<ServiceOffering> services=serviceRepository.findAllById(ids);
        return new HashSet<>(services);
    }

    @Override
    public Optional<ServiceOfferingService> getServiceById(Long id) throws Exception {
        Optional<ServiceOfferingService> serviceOffering= Optional.ofNullable(serviceRepository.findById(id).orElse(null));
        if(serviceOffering==null){
            throw  new Exception("Service not exist with id"+id);
        }
        return serviceOffering;
    }


}

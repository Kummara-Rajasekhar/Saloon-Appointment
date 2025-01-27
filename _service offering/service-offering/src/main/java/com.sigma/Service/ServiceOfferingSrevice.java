package com.sigma.Service;

import com.sigma.DTO.CategoryDTO;
import com.sigma.DTO.SaloonDTO;
import com.sigma.DTO.ServiceDTO;
import com.sigma.Model.ServiceOffering;

import java.util.Set;

public interface ServiceOfferingService {

    ServiceOfferingService createService(SaloonDTO saloonDTO,
                                         ServiceDTO serviceDTO,
                                         CategoryDTO categoryDTO);
    ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception;
    Set<ServiceOffering> getAllServiceBySaloonId(Long saloonId, Long categoryId);
    Set<ServiceOffering> getServicesByIds(Set<Long> ids);
}

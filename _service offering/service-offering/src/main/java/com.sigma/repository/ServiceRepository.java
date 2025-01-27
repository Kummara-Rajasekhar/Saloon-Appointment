package com.sigma.repository;

import com.sigma.Service.ServiceOfferingService;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ServiceRepository extends JpaRepository<ServiceOfferingService, Long> {

    Set<ServiceOfferingService> findBySaloonId(Long saloonId);
}

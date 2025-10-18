package com.agency.digital_agency.service;

import com.agency.digital_agency.Repository.ServiceRepository;
import com.agency.digital_agency.model.Service;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }
}
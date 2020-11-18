package com.co.alaorden.service;

import com.co.alaorden.model.ServiceEntity;
import com.co.alaorden.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    public ServiceEntity create (ServiceEntity service){
        return serviceRepository.save(service);
    }

    public ServiceEntity read (Integer id){
        return serviceRepository.findById(id).get();
    }

    public ServiceEntity update (ServiceEntity service, Integer id){
        ServiceEntity tmpService = serviceRepository.findById(id).get();
        tmpService.setCompanyId(service.getCompanyId());
        tmpService.setDescription(service.getDescription());
        tmpService.setIsNegotiable(service.getIsNegotiable());
        tmpService.setName(service.getName());
        tmpService.setPrice(service.getPrice());
        tmpService.setScore(service.getScore());
        tmpService.setServiceType(service.getServiceType());
        return serviceRepository.save(tmpService);
    }

    public String delete (Integer id){
        serviceRepository.deleteById(id);
        return serviceRepository.findById(id).get() == null ?
                "Eliminada el servicio "+ id.toString() :
                "No se elimino el servicio " + id.toString() ;
    }
}
package com.noobForce.klasa.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noobForce.klasa.model.Resource;
import com.noobForce.klasa.repository.ResourceRepository;

@Service
public class ResourceService 
{
	private final ResourceRepository resourceRepository;
	
	
	@Autowired
    public ResourceService(ResourceRepository resourceRepository)
    {
        this.resourceRepository = resourceRepository;
    }
    
    public Resource addResource(Resource resource)
    {
        return resourceRepository.save(resource);
    }
    
    public List<Resource> getAllResources()
    {
        return resourceRepository.findAll();
    }
    
    public List<Resource> getAllResourcesByDate(int date)
    {
        return resourceRepository.findByDate(LocalDate.of(2021, 06, date));
    }
	
}

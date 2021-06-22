package com.noobForce.klasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
//import java.util.Optional;

import com.noobForce.klasa.model.Resource;
import com.noobForce.klasa.service.ResourceService;



@RestController
@RequestMapping("/resource")

public class ResourceController 
{
	 private final ResourceService resourceService;
	    
	    @Autowired
	    public ResourceController(ResourceService resourceService)
	    {
	        this.resourceService = resourceService;
	    }
	    
	    @GetMapping("/getAll")
	    public ResponseEntity<List<Resource>> getAllResources()
	    {
	        return new ResponseEntity<>(resourceService.getAllResources(), HttpStatus.OK);
	    }
	    
	    @GetMapping("/getAllByDate")
	    public ResponseEntity<List<Resource>> getAllResourcesByDate(@RequestBody LocalDate date)
	    {
	        return new ResponseEntity<>(resourceService.getAllResourcesByDate(date), HttpStatus.OK);
	    }
	    
	    @PostMapping("/add")
	    public ResponseEntity<Resource> addResource(@RequestBody Resource resource)
	    {
	        return new ResponseEntity<>(resourceService.addResource(resource), HttpStatus.CREATED);
	        
	    }
	    
}

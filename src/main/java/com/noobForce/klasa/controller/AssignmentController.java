package com.noobForce.klasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.noobForce.klasa.model.Assignment;
import com.noobForce.klasa.service.AssignmentService;


public class AssignmentController
{
	private final AssignmentService assignmentService;
	
    @Autowired
    public AssignmentController(AssignmentService assignmentService)
    {
        this.assignmentService = assignmentService;
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<Assignment>> getAllAssignments()
    {
        return new ResponseEntity<>(assignmentService.getAllAssignments(), HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Assignment> addAssignment(@RequestBody Assignment assignment)
    {
        return new ResponseEntity<>(assignmentService.addAssignment(assignment), HttpStatus.CREATED);
        
    }
    
    @GetMapping("/getAllByDate/{date}")
    public ResponseEntity<List<Assignment>> getAllAssignmentsByDate(@PathVariable int date, int dueDate)
    {
        return new ResponseEntity<>(assignmentService.getAllAssignmentsByDate(date, dueDate), HttpStatus.OK);
    }

}

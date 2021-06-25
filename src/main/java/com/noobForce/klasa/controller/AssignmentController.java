package com.noobForce.klasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.noobForce.klasa.model.Assignment;
import com.noobForce.klasa.service.AssignmentService;

@RestController
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
    
    @GetMapping("/getAllByDate/{dueDate}")
    public ResponseEntity<List<Assignment>> getAllAssignmentsByDate(@PathVariable int dueDate)
    {
        System.out.println("requested");
        return new ResponseEntity<>(assignmentService.getAllAssignmentsByDate(dueDate), HttpStatus.OK);
    }

}

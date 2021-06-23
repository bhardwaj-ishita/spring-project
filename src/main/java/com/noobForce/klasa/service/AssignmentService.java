package com.noobForce.klasa.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noobForce.klasa.model.Assignment;
import com.noobForce.klasa.repository.AssignmentRepository;


@Service
public class AssignmentService
{
	private final AssignmentRepository assignmentRepository;
	
	@Autowired
    public AssignmentService(AssignmentRepository assignmentRepository)
    {
        this.assignmentRepository = assignmentRepository;
    }
	
    public Assignment addAssignment(Assignment assignment)
    {
        return assignmentRepository.save(assignment);
    }
    
    public List<Assignment> getAllAssignments()
    {
        return assignmentRepository.findAll();
    }
    
    public List<Assignment> getAllAssignmentsByDate(int date, int dueDate)
    {
        return assignmentRepository.findByDateAndDueDate(LocalDate.of(2021, 06, date),LocalDate.of(2021, 06, dueDate));
    }

}

package com.noobForce.klasa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noobForce.klasa.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long>
{

//	List<Assignment> findByDateAndDueDate(LocalDate of, LocalDate of2);
    List<Assignment> findByDueDate(LocalDate of);
}

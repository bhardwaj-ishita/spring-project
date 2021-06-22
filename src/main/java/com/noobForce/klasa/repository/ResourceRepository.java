package com.noobForce.klasa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noobForce.klasa.model.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long>
{

	List<Resource> findByDate(LocalDate date);
	
}

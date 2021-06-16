package com.noobForce.klasa.repository;

import com.noobForce.klasa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>
{
    List<Student> findByEmailAndPassword(String email, String password);
}

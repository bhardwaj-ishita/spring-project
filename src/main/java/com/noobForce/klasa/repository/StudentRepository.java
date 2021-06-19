package com.noobForce.klasa.repository;

import com.noobForce.klasa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
    // or is it findStudentByEmailAndPassword??
    List<Student> findByEmailAndPassword(String email, String password);
    
    List<Student> findByEmail(String email);
}

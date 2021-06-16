package com.noobForce.klasa.service;

import com.noobForce.klasa.model.Student;
import com.noobForce.klasa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.noobForce.klasa.exceptions.StudentNotFoundException;

import java.util.List;

@Service
public class StudentService
{
    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }
    
    public Student addStudent(Student student)
    {
        // setUUID?
        return studentRepository.save(student);
    }
    
    public Student findStudent(Long id)
    {
        return studentRepository
                .findById(id).orElseThrow( () ->
                        new StudentNotFoundException("Student with id: " + id.toString() + " was not found"));
        
    }
    
    public Student updateStudent(Student student)
    {
        return studentRepository.save(student);
    }
    
    public Student signInStudent(String email, String password)
    {
        Student student = studentRepository.findByEmailAndPassword(email, password).get(0);
        student.setLoggedIn(true);
        return updateStudent(student);
    }
    
    
    public Student signOutStudent(String email, String password)
    {
        Student student = studentRepository.findByEmailAndPassword(email, password).get(0);
        student.setLoggedIn(false);
        return updateStudent(student);
    }
    
    public Boolean hasAccount(String email, String password)
    {
        List<Student> studentAccount = studentRepository.findByEmailAndPassword(email, password);
        return studentAccount.size() > 0;
    }

}


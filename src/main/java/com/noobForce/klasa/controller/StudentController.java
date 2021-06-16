package com.noobForce.klasa.controller;


import com.noobForce.klasa.model.Student;
import com.noobForce.klasa.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController
{
    private final StudentService studentService;
    
    public StudentController(StudentService studentServic)
    {
        this.studentService = studentServic;
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id)
    {
        return new ResponseEntity<>(studentService.findStudent(id), HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }
    
    @GetMapping("/hasAccount/{email}/{password}")
    public ResponseEntity<Boolean> hasAccount(@PathVariable String email, @PathVariable String password)
    {
        return new ResponseEntity<>(studentService.hasAccount(email, password), HttpStatus.OK);
    }
    
    @PutMapping("/signin/{email}/{password}")
    public ResponseEntity<Student> signInStudent(@PathVariable String email, @PathVariable String password)
    {
        return new ResponseEntity<>(studentService.signInStudent(email, password), HttpStatus.OK);
    }
    
    @PutMapping("signout/{email}/{password}")
    public ResponseEntity<Student> signOutStudent(@PathVariable String email, @PathVariable String password)
    {
        return new ResponseEntity<>(studentService.signOutStudent(email, password), HttpStatus.OK);
    }
}

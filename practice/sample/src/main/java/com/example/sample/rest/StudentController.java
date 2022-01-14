package com.example.sample.rest;

import com.example.sample.dtos.StudentDto;
import com.example.sample.model.Student;
import com.example.sample.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private IStudentService service;

  /*  @GetMapping("/home")
    public String getStudent() {
        return "Welcome to Home page";
    }*/
    @GetMapping("/Students")
    public List<StudentDto> getStudent(){
        return service.getStudent();
    }

    @PostMapping("/save")
    public StudentDto saveStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }
}

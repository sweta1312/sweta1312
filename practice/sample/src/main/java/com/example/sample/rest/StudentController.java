package com.example.sample.rest;

import com.example.sample.dtos.StudentDto;
import com.example.sample.model.Student;
import com.example.sample.service.IStudentService;
import com.example.sample.service.StudentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("/fetch")
    public List<StudentDto> getStudent(){
        List<StudentDto> studentDtos = null;
        try {
            studentDtos =  service.getStudent();
        } catch (Exception | StudentNotFoundException e ) {
            LOGGER.error("Could not find any students");
            e.printStackTrace();

        }
        return studentDtos;
    }

    @PostMapping("/create")
    public StudentDto saveStudent(@RequestBody Student student) {

        return service.saveStudent(student);
    }

}

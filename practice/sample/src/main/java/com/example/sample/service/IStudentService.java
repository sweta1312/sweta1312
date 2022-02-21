package com.example.sample.service;

import com.example.sample.dtos.StudentDto;
import com.example.sample.model.Student;

import java.util.List;

public interface IStudentService {

     //post
     StudentDto saveStudent(Student s);

     //get
     List<StudentDto> getStudent() throws StudentNotFoundException;

}

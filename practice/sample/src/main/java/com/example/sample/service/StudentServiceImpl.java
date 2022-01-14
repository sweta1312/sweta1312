package com.example.sample.service;

import com.example.sample.dtos.StudentDto;
import com.example.sample.model.Student;
import com.example.sample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
    public class StudentServiceImpl implements IStudentService {

    @Autowired
    public StudentRepository repo;


    @Override
    public StudentDto saveStudent(Student s) {
       Student savedStudent = repo.save(s);
        StudentDto studentDto = new StudentDto();
        studentDto.setId(s.getId());
        studentDto.setName(s.getName());
        return studentDto;

    }

    @Override
    public List<StudentDto> getStudent() {
        return repo.findAll().stream()
                .map(this::saveStudent)
                .collect(Collectors.toList());
    }
}

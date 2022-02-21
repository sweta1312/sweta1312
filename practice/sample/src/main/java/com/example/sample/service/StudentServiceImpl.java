package com.example.sample.service;

import com.example.sample.dtos.AddressDto;
import com.example.sample.dtos.StudentDto;
import com.example.sample.model.Address;
import com.example.sample.model.Student;
import com.example.sample.repository.AddressRepository;
import com.example.sample.repository.DrivingLicenceRepository;
import com.example.sample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    public StudentRepository repo;

    @Autowired
    public AddressRepository addrepo;

    public DrivingLicenceRepository dlrepo;

    @Override
    public StudentDto saveStudent(Student s) {
        Student savedStudent = repo.save(s);

        StudentDto studentDto = new StudentDto();
        studentDto.setId(savedStudent.getId());
        studentDto.setName(savedStudent.getName());
        studentDto.setAddresses(savedStudent.getAddresses());
        studentDto.setDrivingLicence(savedStudent.getDrivingLicence());
        return studentDto;

    }

    @Override
    public List<StudentDto> getStudent() throws StudentNotFoundException {


        List<Student> studentsList = repo.findAll();
        if (studentsList.size() > 0) {
            return studentsList.stream()
                    .map(this::saveStudent)
                    .collect(Collectors.toList());
        } else {
            throw new StudentNotFoundException("students not found ");
        }

    }
}

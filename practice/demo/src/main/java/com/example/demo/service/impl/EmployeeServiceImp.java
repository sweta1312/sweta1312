package com.example.demo.service.impl;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements IEmployeeService {

    @Autowired
    private EmployeeRepository repo; // HAS-A

}

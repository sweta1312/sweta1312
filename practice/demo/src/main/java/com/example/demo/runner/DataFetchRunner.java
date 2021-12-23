package com.example.demo.runner;

import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataFetchRunner implements CommandLineRunner {
    @Autowired
    private EmployeeRepository repo;
    @Override
    public void run(String... args) throws Exception {
     

    }
}

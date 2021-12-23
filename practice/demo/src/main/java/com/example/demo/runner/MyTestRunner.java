package com.example.demo.runner;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//@Component
public class MyTestRunner implements CommandLineRunner {
    @Autowired
    private EmployeeRepository repo;
    @Override
    public void run(String... args) throws Exception {

        repo.save(new Employee(10,"sweta", "Hyd"));
        repo.save(new Employee(11,"Anup", "Delhi"));
        repo.save(new Employee(12,"Shivam", "Merrut"));
        repo.save(new Employee(13,"Chiranjeev", "Delhi"));
        repo.save(new Employee(14,"Asad", "Jaipur"));


    }
}

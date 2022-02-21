package com.asset.assetmanagement.service.impl;

import com.asset.assetmanagement.dtos.EmployeeDto;
import com.asset.assetmanagement.entity.Employee;
import com.asset.assetmanagement.exception.EmployeeNotFoundException;
import com.asset.assetmanagement.repo.EmployeeRepository;
import com.asset.assetmanagement.service.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository repo;

    ModelMapper mapper=new ModelMapper();

    @Override
    public Long saveEmployee(EmployeeDto dto) {
        Employee toSave = mapper.map(dto, Employee.class);
        return repo.save(toSave).getId();
    }

    @Override
    public String updateEmployee(EmployeeDto e) {
        Optional<Employee> exit = repo.findById(e.getId());
        String message="";
        if(exit.isPresent())
        {
            Employee tosave = mapper.map(e, Employee.class);
            Employee savedemployee = repo.save(tosave);
            message="Employee " +e.getId()+ "updated successfully";
        }
        else
        {
            message="Employee " +e.getId()+ "not exist";
        }
       return message;
    }

    @Override
    public void deleteEmployee(Long id) {

        Optional<Employee> exist = repo.findById(id);
        if(exist.isPresent())
        {
            repo.deleteById(exist.get().getId());

        }
        else throw new EmployeeNotFoundException("Employee with id " +id+ "doesnot exist");
    }
    @Override
    public Employee getOneEmployee(Long id)
    {
        return repo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Not Found"));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = repo.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for(Employee employee:employeeList)
        {
            EmployeeDto dto = mapper.map(employee, EmployeeDto.class);
            employeeDtoList.add(dto);
        }
        return employeeDtoList;
    }
}

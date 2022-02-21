package com.asset.assetmanagement.service;

import com.asset.assetmanagement.dtos.EmployeeDto;
import com.asset.assetmanagement.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    Long saveEmployee(EmployeeDto dto);

    String updateEmployee(EmployeeDto dto);

    void deleteEmployee(Long id);

    Employee getOneEmployee(Long id);

    List<EmployeeDto> getAllEmployees();
}

package com.asset.assetmanagement.controller;

import com.asset.assetmanagement.dtos.EmployeeDto;
import com.asset.assetmanagement.entity.Employee;
import com.asset.assetmanagement.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

    //1.add employee
    @PostMapping("/save")
    public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
        String message=null;
        try {
            if (employeeDto.getId() == null) {
                message = String.valueOf(service.saveEmployee(employeeDto));

                return new ResponseEntity<String>(message, HttpStatus.OK);
            }
            message = "Id shoud be null";
            return new ResponseEntity<String>
                    (message, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e ) {
            e.printStackTrace();
            return  new ResponseEntity<String>("employee with" +employeeDto.getEmpId()+ "already exist",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //2.update
    @PutMapping("/update")
    public ResponseEntity<String> updateInspection(@RequestBody EmployeeDto employeeDto) {
        String response="";
        try {
            if (employeeDto.getId() !=null) {
                response= service.updateEmployee(employeeDto);
                return  ResponseEntity.ok(response);
            }
            return new ResponseEntity<String>("please send id for update",HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            e.printStackTrace();
            response = "Employee with id" + employeeDto.getId() + "doesnot exist";
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //3.get
    @GetMapping(value = "/get",consumes = {MediaType.ALL_VALUE})
    public List<EmployeeDto> getEmployee()
    {
        List<EmployeeDto> employeeDtos=null;
        try
        {
            employeeDtos=service.getAllEmployees();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return employeeDtos;
    }
    //4.delete
    @DeleteMapping(value = "/delete/{id}", consumes = { MediaType.ALL_VALUE })
    public void deleteEmployee(@PathVariable("id") Long id){
        service.deleteEmployee(id);
    }


}

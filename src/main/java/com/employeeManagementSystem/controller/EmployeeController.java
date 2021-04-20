package com.employeeManagementSystem.controller;

import com.employeeManagementSystem.exception.ResourceNotFoundException;
import com.employeeManagementSystem.model.Employee;
import com.employeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //get employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeById(@PathVariable Long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Id Does Not Exist" + id));
        return ResponseEntity.ok(employee);
    }

    // update employee rest api
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee EmployeeDetails, @PathVariable Long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Id Does Not Exist" + id));

        employee.setFirstName(EmployeeDetails.getFirstName());
        employee.setLastName(EmployeeDetails.getLastName());
        employee.setEmailId(EmployeeDetails.getEmailId());

        Employee  updatatedEmployee= employeeRepository.save(employee);
        return ResponseEntity.ok(updatatedEmployee);
    }
}

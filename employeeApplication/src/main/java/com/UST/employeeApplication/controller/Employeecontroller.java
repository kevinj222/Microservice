package com.UST.employeeApplication.controller;

import com.UST.employeeApplication.entity.Employee;
import com.UST.employeeApplication.service.Employeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Employeecontroller {
    @Autowired
    private Employeeservice employeeservice;

    @PostMapping("/register")
    public Employee register(@RequestBody Employee employee){
        return employeeservice.createEmployee(employee);
    }
    @GetMapping("/")
    public List<Employee> getALLEmployee(){
        return employeeservice.getALLEmployee();
    }

    @GetMapping("/employees/{empId}")
	public Employee getEmployeeById(@PathVariable String empId) {
		return employeeservice.getEmployeeByempId(empId);
	}
    @DeleteMapping("/deleteemployee/{empId}")
	public String deleteEmployee(@PathVariable String empId) {
		return employeeservice.deleteEmployeeByempId(empId);
	}

}

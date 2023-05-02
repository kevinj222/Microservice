package com.UST.employeeApplication.service;

import com.UST.employeeApplication.entity.Employee;
import com.UST.employeeApplication.repo.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class Employeeservice {
    @Autowired
    private Employeerepo repo;
    public Employee createEmployee(Employee employee) {
        return repo.save(employee);
    }

    public List<Employee> getALLEmployee() {
        return repo.findAll();
    }

    public Employee getEmployeeByempId(String empId) {
        return repo.findByempId(empId);
    }


    @Transactional
    public String deleteEmployeeByempId(String empId) {
       repo.deleteByempId(empId);
       return "employee deleted";
    }

    public Employee updateEmployee(String empId, Employee employee) {
        Employee existingEmployee = repo.findById(empId).orElse(null);
        if(existingEmployee == null) {
            return null;
        }
        existingEmployee.setEmpname(employee.getEmpname());
        existingEmployee.setEmpemailid(employee.getEmpemailid());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setEmphr(employee.getEmphr());
        return repo.save(existingEmployee);
    }


}

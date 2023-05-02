package com.UST.employeeApplication.repo;

import com.UST.employeeApplication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Employeerepo extends JpaRepository<Employee,String> {


    Employee findByempId(String empId);

    void deleteByempId(java.lang.String empId);
}
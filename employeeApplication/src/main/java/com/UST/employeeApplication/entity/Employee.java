package com.UST.employeeApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "employee_tab")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String empId;
    private String empname;
    private String empemailid;
    private String designation;
    private String emphr;


}

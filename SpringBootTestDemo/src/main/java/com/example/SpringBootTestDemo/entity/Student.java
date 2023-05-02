package com.example.SpringBootTestDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @Column(name="Id")
    private Integer id;
    @NotBlank(message="the column name should not be blank")
    @Column(name="NAME")
    private String name;
    @Column(name="ADRESS")
    private String address;
    @Column(name="ROLLNO")
    private String rollNo;

}

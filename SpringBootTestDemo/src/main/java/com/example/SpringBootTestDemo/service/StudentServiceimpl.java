package com.example.SpringBootTestDemo.service;

import com.example.SpringBootTestDemo.entity.Student;
import com.example.SpringBootTestDemo.exception.StudentNotFoundException;
import com.example.SpringBootTestDemo.repository.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceimpl implements StudentServices {
    @Autowired
    private Studentrepo repo;

    @Override
    public Student addStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional<Student > s=repo.findById(id);
        if(!s.isPresent()){
            throw new StudentNotFoundException("student with id: "+id+  "doesn't exist");
        }
        return s.get();
    }

    @Override
    public Student deleteStudentById(Integer id) {
        Optional<Student > s=repo.findById(id);
        if(!s.isPresent()){
            throw new StudentNotFoundException("student with id: "+id+  "doesn't exist");
        }
        repo.delete((s.get()));
        return null;
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return repo.findByName(name);
    }
}

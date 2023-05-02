package com.UST.colleage.controller;

import com.UST.colleage.entity.College;
import com.UST.colleage.entity.Faculty;
import com.UST.colleage.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges/{collegeId}/faculties")
public class FacultyController {

    @Autowired
    private Faculty teacher;

    @PostMapping
    public ResponseEntity<Faculty> addFaculty(@PathVariable Long collegeId, @RequestBody Faculty faculty) {
        teacher.setCollege(new College(collegeId));
        return new ResponseEntity<>(FacultyService.addFaculty(faculty), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Faculty>> getFacultiesByCollegeId(@PathVariable Long collegeId) {
        return ResponseEntity.ok(FacultyService.getFacultiesByCollegeId(collegeId));
    }

    @GetMapping("/departments/{departmentId}")
    public ResponseEntity<List<Faculty>> getFacultiesByDepartmentId(@PathVariable Long departmentId) {
        return ResponseEntity.ok(FacultyService.getFacultiesByDepartmentId(departmentId));
    }
}
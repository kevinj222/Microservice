package com.UST.colleage.controller;

import com.UST.colleage.entity.College;
import com.UST.colleage.entity.Department;
import com.UST.colleage.entity.Faculty;
import com.UST.colleage.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @PostMapping
    public ResponseEntity<College> addCollege(@RequestBody College college) {
        College newCollege = collegeService.addCollege(college);
        return ResponseEntity.ok(newCollege);
    }

    @GetMapping("/{name}")
    public ResponseEntity<College> getCollegeByName(@PathVariable String name) {
        College college = collegeService.getCollegeByName(name);
        return ResponseEntity.ok(college);
    }

    @PutMapping("/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable Long id, @RequestBody College college) {
        College updatedCollege = collegeService.updateCollege(id, college);
        return ResponseEntity.ok(updatedCollege);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable Long id) {
        collegeService.deleteCollege(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{collegeId}/departments")
    public ResponseEntity<Department> addDepartment(@PathVariable Long collegeId, @RequestBody Department department) {
        Department newDepartment = collegeService.addDepartment(collegeId, department);
        return ResponseEntity.ok(newDepartment);
    }

    @GetMapping("/{collegeName}/departments")
    public ResponseEntity<List<Department>> getDepartmentsByCollegeName(@PathVariable String collegeName) {
        List<Department> departments = collegeService.getDepartmentsByCollegeName(collegeName);
        return ResponseEntity.ok(departments);
    }

    @PostMapping("/{collegeId}/faculties")
    public ResponseEntity<Faculty> addFaculty(@PathVariable Long collegeId, @RequestBody Faculty faculty) {
        Faculty newFaculty = collegeService.addFaculty(collegeId, faculty);
        return ResponseEntity.ok(newFaculty);
    }

    @GetMapping("/{collegeName}/faculties")
    public ResponseEntity<List<Faculty>> getFacultiesByCollegeName(@PathVariable String collegeName) {
        List<Faculty> faculties = collegeService.getFacultiesByCollegeName(collegeName);
        return ResponseEntity.ok(faculties);
    }
}

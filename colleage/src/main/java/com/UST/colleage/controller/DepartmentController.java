package com.UST.colleage.controller;

import com.UST.colleage.entity.Department;
import com.UST.colleage.entity.Faculty;
import com.UST.colleage.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("")
    public ResponseEntity<Department> addDepartment(@Valid @RequestBody Department department) {
        Department newDepartment = departmentService.addDepartment(department);
        return ResponseEntity.ok(newDepartment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") Long id) {
        Department department = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable(value = "id") Long id,
                                                       @Valid @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartment(id, department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable(value = "id") Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{departmentId}/teachers")
    public ResponseEntity<Faculty> addTeacher(@PathVariable(value = "departmentId") Long departmentId,
                                              @Valid @RequestBody Faculty teacher) {
        Faculty newTeacher = departmentService.addTeacher(departmentId, teacher);
        return ResponseEntity.ok(newTeacher);
    }

    @GetMapping("/{departmentId}/teachers")
    public ResponseEntity<List<Faculty>> getTeachersByDepartmentId(@PathVariable(value = "departmentId") Long departmentId) {
        List<Faculty> teachers = departmentService.getTeachersByDepartmentId(departmentId);
        return ResponseEntity.ok(teachers);
    }
}

package com.UST.colleage.service;

import com.UST.colleage.entity.College;
import com.UST.colleage.entity.Department;
import com.UST.colleage.entity.Faculty;
import com.UST.colleage.repo.CollegeRepository;
import com.UST.colleage.repo.DepartmentRepository;
import com.UST.colleage.repo.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    public College addCollege(College college) {
        return collegeRepository.save(college);
    }

    public College getCollegeByName(String name) {
        return collegeRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("College", "name", name));
    }

    public College updateCollege(Long id, College college) {
        College existingCollege = collegeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("College", "id", id));
        existingCollege.setName(college.getName());
        existingCollege.setAddress(college.getAddress());
        existingCollege.setPhone(college.getPhone());
        existingCollege.setEmail(college.getEmail());
        return collegeRepository.save(existingCollege);
    }

    public void deleteCollege(Long id) {
        College college = collegeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("College", "id", id));
        collegeRepository.delete(college);
    }

    public Department addDepartment(Long collegeId, Department department) {
        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new ResourceNotFoundException("College", "id", collegeId));
        department.setCollege(college);
        return departmentRepository.save(department);
    }

    public List<Department> getDepartmentsByCollegeName(String collegeName) {
        return departmentRepository.findByCollegeName(collegeName);
    }

    public Faculty addFaculty(Long collegeId, Faculty teacher) {
        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new ResourceNotFoundException("College", "id", collegeId));
        teacher.setCollege(college);
        return facultyRepository.save(teacher);
    }

    public List<Faculty> getFacultiesByCollegeName(String collegeName) {
        return facultyRepository.findByCollegeName(collegeName);
    }
}

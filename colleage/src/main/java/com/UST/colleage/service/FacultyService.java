package com.UST.colleage.service;

import com.UST.colleage.entity.Faculty;
import com.UST.colleage.repo.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FacultyService
{

    @Autowired
    private FacultyRepository TeacherRepository;

    public Faculty addT(Faculty faculty) {
        return FacultyRepository.save(faculty);
    }

    public List<Faculty> getFacultiesByCollegeId(Long collegeId) {
        return FacultyRepository.findByCollegeId(collegeId);
    }

    public List<Faculty> getFacultiesByDepartmentId(Long departmentId) {
        return FacultyRepository.findByDepartmentId(departmentId);
    }
}

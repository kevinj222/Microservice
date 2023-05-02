package com.UST.InterviewSchedulers.service;

import com.UST.InterviewSchedulers.entity.Interview;
import com.UST.InterviewSchedulers.repo.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Service
public class InterviewService {
    @Autowired
    public InterviewRepository repo;
    public Interview createInterview(Interview interview) {
        return repo.save(interview);
    }
    public List<Interview> getALLInterviewee() {
        return repo.findAll();
    }

    public Interview getIntervieweeByempId(Long id) {
        return repo.findById(id).orElse(null);
    }

}

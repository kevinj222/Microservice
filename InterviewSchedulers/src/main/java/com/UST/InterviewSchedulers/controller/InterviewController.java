package com.UST.InterviewSchedulers.controller;

import com.UST.InterviewSchedulers.entity.Interview;
import com.UST.InterviewSchedulers.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interview")
public class InterviewController {
    @Autowired
    public InterviewService interviewservice;

    @PostMapping("/register")
    public Interview register(@RequestBody Interview interview){
        return interviewservice.createInterview(interview);
    }
    @GetMapping("/")
    public List<Interview> getALLEmployee(){
        return interviewservice.getALLInterviewee();
    }

    @GetMapping("/interviews/{id}")
    public Interview getEmployeeById(@PathVariable Long id) {
        return interviewservice.getIntervieweeByempId(id);
    }
}

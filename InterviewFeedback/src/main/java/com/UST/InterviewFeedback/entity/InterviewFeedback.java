package com.UST.InterviewFeedback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class InterviewFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String userId;
    private String CandidateName;
    private String Position;
    private String InterviewerName;
    private String InterviewerEmpid;
    private int rating;
    private String status;

    public InterviewFeedback() {
    }

    public InterviewFeedback(Long id, String userId, String candidateName, String position, String interviewerName, String interviewerEmpid, int rating, String status) {
        this.id = id;
        this.userId = userId;
        CandidateName = candidateName;
        Position = position;
        InterviewerName = interviewerName;
        InterviewerEmpid = interviewerEmpid;
        this.rating = rating;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCandidateName() {
        return CandidateName;
    }

    public void setCandidateName(String candidateName) {
        CandidateName = candidateName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getInterviewerName() {
        return InterviewerName;
    }

    public void setInterviewerName(String interviewerName) {
        InterviewerName = interviewerName;
    }

    public String getInterviewerEmpid() {
        return InterviewerEmpid;
    }

    public void setInterviewerEmpid(String interviewerEmpid) {
        InterviewerEmpid = interviewerEmpid;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.UST.InterviewFeedback.dto;

public class InterviewFeedbackDTO  {
    private Long id;
    private String userId;
    private String CandidateName;
    private String Position;
    private String InterviewerName;
    private String InterviewerEmpid;
    private int rating;
    private String status;

    public InterviewFeedbackDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCandidateName(String CandidateName) {
        this.CandidateName = CandidateName;
    }

    public String getCandidateName() {
        return this.CandidateName;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public String getPosition() {
        return this.Position;
    }

    public void setInterviewerName(String InterviewerName) {
        this.InterviewerName = InterviewerName;
    }

    public String getInterviewerName() {
        return this.InterviewerName;
    }

    public void setInterviewerEmpid(String InterviewerEmpid) {
        this.InterviewerEmpid = InterviewerEmpid;
    }

    public String getInterviewerEmpid() {
        return this.InterviewerEmpid;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return this.rating;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
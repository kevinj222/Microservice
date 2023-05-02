package com.UST.InterviewSchedulers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="interview_tbl")
public class Interview {
    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String emailid;
    private String phnno;
    private String skills;
    private int experience;
    private String date;
    private String time;
    private String link;
    private String poc;
}

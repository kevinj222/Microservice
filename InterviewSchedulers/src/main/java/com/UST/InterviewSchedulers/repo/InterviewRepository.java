package com.UST.InterviewSchedulers.repo;

import com.UST.InterviewSchedulers.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,Long> {

}

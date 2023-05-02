package com.UST.colleage.repo;

import com.UST.colleage.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

    College findByName(String name);
}

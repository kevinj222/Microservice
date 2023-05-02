package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.Eentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Erepo extends JpaRepository<Eentity,String> {
}

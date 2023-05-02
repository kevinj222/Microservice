package com.example.Ecommerce.service;


import com.example.Ecommerce.entity.Eentity;
import com.example.Ecommerce.repository.Erepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Eservice {

@Autowired
private Erepo repo;
    public Eentity add(Eentity eentity) {
        return repo.save(eentity);
    }
}

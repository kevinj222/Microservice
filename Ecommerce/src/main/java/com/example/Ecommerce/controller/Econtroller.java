package com.example.Ecommerce.controller;


import com.example.Ecommerce.entity.Eentity;
import com.example.Ecommerce.service.Eservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Econtroller {


        @Autowired
        private Eservice eservice;

        @PostMapping("/ddd")
        public Eentity add(@RequestBody Eentity eentity) {
                return eservice.add(eentity);
        }
}

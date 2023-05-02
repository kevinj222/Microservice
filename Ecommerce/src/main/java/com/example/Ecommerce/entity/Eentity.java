package com.example.Ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Eentity {
    @Id
    private String carId;
    private String carName;
    private String year;
    @ElementCollection
    //@Enumerated(EnumType.STRING)
    private List<String> colors;


    private String model;
    @ElementCollection
    private List<String> Accessories;
    private Integer price;
    @ElementCollection
    private List<String>  payment;
    @ElementCollection
    private  List<String> city;


}

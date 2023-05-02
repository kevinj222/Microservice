package com.UST.statemapping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class State {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    private  @Id String state;
    private String districts;


}

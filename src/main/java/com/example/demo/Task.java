package com.example.demo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "tasks")
    private List<Employee> employees;

}
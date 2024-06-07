package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String budget;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees;
}

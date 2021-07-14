package com.sda.humanresourcesapplication.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity()
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Transient
    private double budget;
    @Transient
    private String currency;
    @Enumerated(EnumType.STRING)
    @Column
    private ProjectType projectType;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();


}

package com.example.semestralka.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "idDepartment")
    private Long idDepartment;

    @Column(name="title")
    String title;

    @Column(name="shortcut")
    String shortcut;

    @OneToMany(
            mappedBy = "department",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<Employees> employees;

    public Department() {
    }

    public Department(String title, String shortcut) {
        this.title = title;
        this.shortcut = shortcut;
    }

    public Long getIdDepartment() {
        return idDepartment;
    }

    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getTitle() {
        return title;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

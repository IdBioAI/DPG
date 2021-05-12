package com.example.semestralka.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="specialization")
public class Specialization {
    @Id
    @GeneratedValue
    @Column(name = "idSpecialization")
    private Long idSpecialization;

    @Column(name="title")
    String title;

    @Column(name="shortcut")
    String shortcut;

    @OneToMany(
            mappedBy = "specialization",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<Employees> employees;

    public Specialization() {
    }

    public Specialization(String title, String shortcut) {
        this.title = title;
        this.shortcut = shortcut;
    }

    public Long getIdSpecialization() {
        return idSpecialization;
    }

    public void setIdSpecialization(Long idSpecialization) {
        this.idSpecialization = idSpecialization;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }
}

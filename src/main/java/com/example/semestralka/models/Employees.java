package com.example.semestralka.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEmployyes")
    private Long idEmployyes;

    @Column(name="firstname")
    String firstname;

    @Column(name="lastname")
    String lastname;

    @Column(name="birth")
    Date birth;

    @ManyToOne
    @JoinColumn(name = "idDepartment")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "idSpecialization")
    private Specialization specialization;

    public Employees() {
    }

    public Employees(String firstname, String lastname, Date birth, Department department, Specialization specialization) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birth = birth;
        this.department = department;
        this.specialization = specialization;
    }

    public Long getIdEmployyes() {
        return idEmployyes;
    }

    public void setIdEmployyes(Long idEmployyes) {
        this.idEmployyes = idEmployyes;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Department getDepartment() {
        return department;
    }

    public String getLastname() {
        return lastname;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

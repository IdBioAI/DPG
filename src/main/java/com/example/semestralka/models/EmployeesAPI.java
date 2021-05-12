package com.example.semestralka.models;

import java.sql.Date;

public class EmployeesAPI {

    private String firstname;
    private String lastname;
    private Date birth;
    private Long idDepartment;
    private Long idSpecialization;

    public EmployeesAPI() {
    }

    public EmployeesAPI(String firstname, String lastname, Date birth, Long idDepartment, Long idSpecialization) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birth = birth;
        this.idDepartment = idDepartment;
        this.idSpecialization = idSpecialization;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
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

    public Long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }

    public Long getIdSpecialization() {
        return idSpecialization;
    }

    public void setIdSpecialization(Long idSpecialization) {
        this.idSpecialization = idSpecialization;
    }
}

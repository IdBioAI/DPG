package com.example.semestralka.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class DepartmentAPI {

    private Long idDepartment;
    private String title;
    private String shortcut;

    public DepartmentAPI(Long idDepartment, String title, String shortcut) {
        this.idDepartment = idDepartment;
        this.title = title;
        this.shortcut = shortcut;
    }

    public Long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
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
}

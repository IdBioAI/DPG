package com.example.semestralka.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class SpecializationAPI {
    private Long idSpecialization;
    private String title;
    private String shortcut;

    public SpecializationAPI(Long idSpecialization, String title, String shortcut) {
        this.idSpecialization = idSpecialization;
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
}

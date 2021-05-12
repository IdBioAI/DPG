package com.example.semestralka.services;

import com.example.semestralka.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.Optional;

@Service
public class MainService {

    @Autowired
    public DepartmentRepository departmentRepository;
    @Autowired
    public EmployeesRepository employeesRepository;
    @Autowired
    public SpecializationRepository specializationRepository;

    Logger log = LoggerFactory.getLogger(getClass());

    @PostConstruct
    private void start(){

    }
}

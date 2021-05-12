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
        log.info("DEBUG");

        /*Department d = new Department("technika", "IT");
        departmentRepository.save(d);
        d = new Department("technika2","IT2");
        departmentRepository.save(d);
        d = new Department("technika3","IT3");
        departmentRepository.save(d);

        Specialization s = new Specialization("special1", "SPEC1");
        specializationRepository.save(s);
        s = new Specialization("special2","SPEC2");
        specializationRepository.save(s);
        s = new Specialization("special3","SPEC3");
        specializationRepository.save(s);

        Date f = Date.valueOf("1991-03-31");
        Employees a = new Employees("Jaroslav2", "Vondrak", f, d, s);
        employeesRepository.save(a);*/

        //Optional<Department> d = departmentRepository.findById((long) 1);
        //Optional<Employees> e = employeesRepository.findById((long) 1);

        //Employees e = new Employees("Jaroslav2", d.get());
        //employeesRepository.save(e);
    }
}

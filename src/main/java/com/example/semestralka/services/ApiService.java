package com.example.semestralka.services;

import com.example.semestralka.models.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiService {

    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    SpecializationRepository specializationRepository;

    /******************** EMPLOYEES ***************************/

    @GetMapping("/employees")
    public JSONObject findAllUsers() {
        return EmployeesToJson(employeesRepository.findAll());
    }

    @GetMapping("/employees/{id}")
    public JSONObject findEmployees(@PathVariable Long id) {
        Optional<Employees> emp = employeesRepository.findById(id);
        return EmployeesToJson(toList(emp));
    }

    @DeleteMapping("/deleteEmployees/{id}")
    public void deleteEmployees(@PathVariable Long id) {
        employeesRepository.deleteEmp(id);
    }

    @PostMapping("/addEmployees")
    public void addEmployees(@RequestBody EmployeesAPI employeesAPI) {
        Optional<Department> department = departmentRepository.findById(employeesAPI.getIdDepartment());
        Optional<Specialization> specialization = specializationRepository.findById(employeesAPI.getIdSpecialization());
        if(department.isPresent() && specialization.isPresent()){
            Employees e = new Employees(employeesAPI.getFirstname(), employeesAPI.getLastname(), employeesAPI.getBirth(), department.get(), specialization.get());
            employeesRepository.save(e);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "department or specialization not found");
        }
    }

    @PutMapping("/editEmployees/{id}")
    public void editEmployees(@PathVariable Long id, @RequestBody EmployeesAPI employeesAPI) {
        Optional<Department> department = departmentRepository.findById(employeesAPI.getIdDepartment());
        Optional<Specialization> specialization = specializationRepository.findById(employeesAPI.getIdSpecialization());
        if(department.isPresent() && specialization.isPresent()){
            Employees e = new Employees(employeesAPI.getFirstname(), employeesAPI.getLastname(), employeesAPI.getBirth(), department.get(), specialization.get());
            e.setIdEmployyes(id);
            employeesRepository.save(e);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "department or specialization not found");
        }
    }
    /********************** DEPARTMENTS *************************/

    @GetMapping("/departments")
    public JSONObject findAllDepartments() {
        return DepartmentsToJson(departmentRepository.findAll());
    }

    @GetMapping("/departments/{id}")
    public JSONObject findDepartment(@PathVariable Long id) {
        Optional<Department> dep = departmentRepository.findById(id);
        return DepartmentsToJson(toList(dep));
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentRepository.deleteById(id);
    }

    @PostMapping("/addDepartment")
    public void addDepartment(@RequestBody DepartmentAPI departmentAPI) {
        Department d = new Department(departmentAPI.getTitle(), departmentAPI.getShortcut());
        departmentRepository.save(d);
    }

    @PutMapping("/editDepartment/{id}")
    public void editDepartment(@PathVariable Long id, @RequestBody DepartmentAPI departmentAPI) {
        Department d = new Department(departmentAPI.getTitle(), departmentAPI.getShortcut());
        d.setIdDepartment(id);
        departmentRepository.save(d);
    }
    /************************ SPECIALIZATION ***********************/

    @GetMapping("/specialization")
    public JSONObject findAllSpecialization() {
        return SpecializationToJson(specializationRepository.findAll());
    }

    @GetMapping("/specialization/{id}")
    public JSONObject findAllSpecialization(@PathVariable Long id) {
        Optional<Specialization> spec = specializationRepository.findById(id);
        return SpecializationToJson(toList(spec));
    }

    @DeleteMapping("/deleteSpecialization/{id}")
    public void deleteSpecialization(@PathVariable Long id) {
        specializationRepository.deleteById(id);
    }

    @PostMapping("/addSpecialization")
    public void addSpecialization(@RequestBody SpecializationAPI specializationAPI) {
        Specialization d = new Specialization(specializationAPI.getTitle(), specializationAPI.getShortcut());
        specializationRepository.save(d);
    }

    @PutMapping("/editSpecialization/{id}")
    public void editSpecialization(@PathVariable Long id, @RequestBody SpecializationAPI specializationAPI) {
        Specialization s = new Specialization(specializationAPI.getTitle(), specializationAPI.getShortcut());
        s.setIdSpecialization(id);
        specializationRepository.save(s);
    }
    /**************************************************************/

    private JSONObject EmployeesToJson( List<Employees> employees){
        JSONObject employeesJson = new JSONObject();
        JSONObject obj;
        for(Employees e : employees){
            obj = new JSONObject();
            obj.put("firstname", e.getFirstname());
            obj.put("lastname", e.getLastname());
            obj.put("birth", e.getBirth());
            obj.put("idDepartment", e.getDepartment().getIdDepartment());
            obj.put("idSpecialization", e.getSpecialization().getIdSpecialization());
            employeesJson.put(e.getIdEmployyes(), obj);
        }

        return employeesJson;
    }

    private JSONObject DepartmentsToJson(List<Department> departments){
        JSONObject departmentsJson = new JSONObject();

        JSONObject obj;
        for(Department d : departments){
            obj = new JSONObject();
            obj.put("title", d.getTitle());
            obj.put("shortcut", d.getShortcut());
            departmentsJson.put(d.getIdDepartment(), obj);
        }

        return departmentsJson;
    }

    private JSONObject SpecializationToJson(List<Specialization> specializations){
        JSONObject specializationJson = new JSONObject();

        JSONObject obj;
        for(Specialization s : specializations){
            obj = new JSONObject();
            obj.put("title", s.getTitle());
            obj.put("shortcut", s.getShortcut());
            specializationJson.put(s.getIdSpecialization(), obj);
        }

        return specializationJson;
    }

    public static <T> List<T> toList(Optional<T> opt) {
        return opt.isPresent()
                ? Collections.singletonList(opt.get())
                : Collections.emptyList();
    }

}

package com.example.semestralka.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Employees WHERE idEmployyes = ?1")
    void deleteEmp(Long id);
}

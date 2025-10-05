package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // optional, Spring Boot خودش interface های JpaRepository را شناسایی میکند
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
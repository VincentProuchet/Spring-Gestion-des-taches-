package com.gdt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdt.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

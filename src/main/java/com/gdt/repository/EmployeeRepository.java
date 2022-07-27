package com.gdt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdt.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Optional<Employee> findByUserName(String userName);
}

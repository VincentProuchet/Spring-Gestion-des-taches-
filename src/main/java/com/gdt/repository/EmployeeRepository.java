package com.gdt.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gdt.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Optional<Employee> findByUserName(String userName);

	@Query("SELECT e FROM Employee e WHERE e.userName LIKE CONCAT('%',:username,'%')")
	Stream<Employee> search(@Param("username") String username);
	
}

package com.gdt.service;

import java.util.List;

import com.gdt.entities.Employee;

public interface EmployeeService {
	
	List<Employee> search();
	
	void create(Employee employee);
	Employee read(Long id);
	Employee update(Employee employee,Long id);
	void delete(Long id);
	
	void taskToUser(Long taskId, Long userId);
}

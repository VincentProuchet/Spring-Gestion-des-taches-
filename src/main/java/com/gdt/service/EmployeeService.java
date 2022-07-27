package com.gdt.service;

import java.util.List;

import com.gdt.entities.Employee;
import com.gdt.exceptions.BadRequestException;

public interface EmployeeService {
	
	List<Employee> search();
	
	void create(Employee employee) throws Exception;
	Employee read(Long id) throws Exception;
	Employee update(Employee employee,Long id) throws Exception;
	void delete(Long id);
	
	void taskToUser(Long taskId, Long userId) throws Exception;
}

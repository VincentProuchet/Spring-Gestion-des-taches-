package com.gdt.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdt.entities.Employee;
import com.gdt.repository.EmployeeRepository;
import com.gdt.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository repository;
	

	public EmployeeServiceImpl(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Employee> search() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void create(Employee employee) {
		repository.save(employee);
	}

	@Override
	public Employee read(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Employee update(Employee employee,Long id) {
		Employee current = this.read(id);
		current.setFirstName(employee.getFirstName());
		current.setLastName(employee.getLastName());
		return current;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void taskToUser(Long taskId, Long userId) {
		// TODO Auto-generated method stub

	}

}

package com.gdt.controller;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gdt.entities.Employee;
import com.gdt.service.EmployeeService;

@RestController
@RequestMapping(path="employee",produces = MediaType.APPLICATION_JSON_VALUE )
public class EmployeeControler {
	
	private EmployeeService service;

	public EmployeeControler(EmployeeService service) {
		super();
		this.service = service;
	}
	@PostMapping
	public void create(@RequestBody Employee employee) {
		this.service.create(employee);
		
	}
	
	
	///////////////////////////////////////////////////////
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public Employee read(Long id) {
		return service.read(id);
	}
	
	
	
	
}

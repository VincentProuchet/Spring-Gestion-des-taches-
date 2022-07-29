package com.gdt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gdt.dto.UserTaskDTO;
import com.gdt.entities.Employee;
import com.gdt.exceptions.BadRequestException;
import com.gdt.exceptions.ErrorCodes;
import com.gdt.service.EmployeeService;

/**
 * @author Vincent
 *
 */
@RestController
@RequestMapping(path = "employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeControler {

	/** service */
	private EmployeeService service;

	/** Constructeur
	 * @param service
	 */
	public EmployeeControler(EmployeeService service) {
		super();
		this.service = service;
	}

	/**
	 * @param employee
	 * @throws Exception
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public void create(@RequestBody Employee employee) throws Exception {
		this.service.create(employee);

	}

	//@ResponseStatus(HttpStatus.CREATED)
	//@PostMapping(path = "/batch")
	/**
	 * @param employees
	 * @throws Exception
	 */
	public void create(@RequestBody Employee[] employees) throws Exception {

		for (Employee employee : employees) {
			this.service.create(employee);
		}
	}

	///////////////////////////////////////////////////////
	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/{id}")
	public Employee read(@PathVariable Integer id) throws Exception {
		return service.read(id);
	}

	/**
	 * @return
	 */
	@GetMapping()
	public List<Employee> search() {
		return this.service.search();
	}
	/**
	 * @param userTask
	 * @param employeeId
	 * @throws Exception
	 */
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping(path = "/{employeeId}/task")
	public void taskToUser(@Validated @RequestBody UserTaskDTO userTask, @PathVariable Integer employeeId) throws Exception {
		if(userTask.getUserId()!= employeeId){
			throw new BadRequestException("les Données ne correspondent pas entres-elles ",ErrorCodes.DATA_INTEGRITY_ERROR );
		}
		service.taskToUser(userTask.getTaskId(), employeeId);		
	}

}

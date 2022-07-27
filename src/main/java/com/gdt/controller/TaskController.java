package com.gdt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gdt.entities.Task;
import com.gdt.exceptions.BadRequestException;
import com.gdt.service.TaskService;

@RestController
@RequestMapping(path="task", produces= MediaType.APPLICATION_JSON_VALUE)
public class TaskController {

	
	/** service l'interface pour l'implémentation du service que nous allons utiliser pour
	 * la persistence des données 
	 *  
	 * 
	 */
	private TaskService service;

	public TaskController(TaskService service) {
		super();
		this.service = service;
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Task task) throws BadRequestException {
		this.service.create(task);
	}
	
	@GetMapping(path = "/{id}")
	public Task read(@PathVariable Long id) throws BadRequestException {
		return this.service.read(id);
	}

}

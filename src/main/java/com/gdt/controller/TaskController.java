package com.gdt.controller;

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

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path="task", produces= MediaType.APPLICATION_JSON_VALUE)
public class TaskController {

	
	/** service l'interface pour l'implémentation du service que nous allons utiliser pour
	 * la persistence des données 
	 *  
	 * 
	 */
	private TaskService service;


	/**
	 * @param task
	 * @throws BadRequestException
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Task task) {
		this.service.create(task);
	}
	
	/**
	 * @param id
	 * @return
	 * @throws BadRequestException
	 */
	@GetMapping(path = "/{id}")
	public Task read(@PathVariable Integer id) {
		return this.service.read(id);
	}

}

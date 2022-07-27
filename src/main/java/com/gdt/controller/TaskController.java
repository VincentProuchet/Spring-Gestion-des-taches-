package com.gdt.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdt.entities.Task;
import com.gdt.service.TaskService;

@RestController
@RequestMapping(path="task", produces= MediaType.APPLICATION_JSON_VALUE)
public class TaskController {
///////////////////////////////////////////////////////////////////////
	private TaskService service;

	public TaskController(TaskService service) {
		super();
		this.service = service;
	}
	@PostMapping
	public void create(@RequestBody Task task) {
		this.service.create(task);
	}
	
	
	
}

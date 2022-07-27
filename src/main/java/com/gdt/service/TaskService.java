package com.gdt.service;

import com.gdt.entities.Task;
import com.gdt.exceptions.BadRequestException;

public interface TaskService {
//	List<Task> search();

	void create(Task task) throws BadRequestException;

	Task read(Long id) throws BadRequestException;

//	Task update(Task task);
//
//	void delete(Long id);
}

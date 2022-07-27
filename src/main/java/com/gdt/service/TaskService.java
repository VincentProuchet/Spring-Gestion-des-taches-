package com.gdt.service;

import java.util.List;

import com.gdt.entities.Employee;
import com.gdt.entities.Task;

public interface TaskService {
//	List<Task> search();

	void create(Task task);

	Task read(Long id);

//	Task update(Task task);
//
//	void delete(Long id);
}

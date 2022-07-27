package com.gdt.service.impl;

import org.springframework.stereotype.Service;

import com.gdt.entities.Task;
import com.gdt.exceptions.BadRequestException;
import com.gdt.exceptions.ErrorCodes;
import com.gdt.repository.TaskRepository;
import com.gdt.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	private TaskRepository repository;

	public TaskServiceImpl(TaskRepository taskRepository) {
		super();
		this.repository = taskRepository;
	}

	@Override
	public void create(Task task) {
		// check TI < TR
		// TR = 0 parce que création
		task.setRt(task.getIt());
		this.repository.save(task);
	}

	@Override
	public Task read(Long id) throws BadRequestException {

		return this.repository.findById(id).orElseThrow(()-> new BadRequestException("l'utilisateur n'existe pas",ErrorCodes.USER_NOT_FOUND));
	}

}

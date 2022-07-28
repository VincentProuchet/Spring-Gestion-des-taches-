package com.gdt.service.impl;

import org.springframework.stereotype.Service;

import com.gdt.entities.Task;
import com.gdt.exceptions.BadRequestException;
import com.gdt.exceptions.ErrorCodes;
import com.gdt.repository.TaskRepository;
import com.gdt.service.TaskService;

/**
 * @author Vincent
 *
 */
@Service
public class TaskServiceImpl implements TaskService {

	/** repository */
	private TaskRepository repository;

	/** Constructeur
	 * @param taskRepository
	 */
	public TaskServiceImpl(TaskRepository taskRepository) {
		super();
		this.repository = taskRepository;
	}

	/** nouvelle tache
	 *
	 */
	@Override
	public void create(Task task) {
		// check TI < TR
		// TR = 0 parce que création
		task.setRt(task.getIt());
		this.repository.save(task);
	}

	/** find by id
	 *
	 */
	@Override
	public Task read(Integer id) throws BadRequestException {

		return this.repository.findById(id).orElseThrow(()-> new BadRequestException("l'utilisateur n'existe pas",ErrorCodes.USER_NOT_FOUND));
	}

}

package com.gdt.service;

import com.gdt.entities.Task;
import com.gdt.exceptions.BadRequestException;

/**
 * @author Vincent
 *
 */
public interface TaskService {
//	List<Task> search();

	/**
	 * @param task
	 */
	void create(Task task) ;

	/**
	 * @param id
	 * @return
	 */
	Task read(Integer id) ;

//	Task update(Task task);
//
//	void delete(Long id);
}

package com.gdt.service;

import java.util.List;

import com.gdt.entities.Employee;
import com.gdt.exceptions.BadRequestException;

/**
 * @author Vincent
 *
 */
public interface EmployeeService {
	
	/**
	 * @return
	 */
	List<Employee> search();
	
	/**
	 * @param employee
	 * @throws Exception
	 */
	void create(Employee employee) throws Exception;
	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Employee read(Long id) throws Exception;
	/** met à jour un employee
	 * @param employee
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Employee update(Employee employee,Long id) throws Exception;
	/** suprime un employee
	 * @param id
	 */
	void delete(Long id);
	
	/** attribue une tache à un Employee
	 * @param taskId
	 * @param userId
	 * @throws Exception
	 */
	void taskToUser(Long taskId, Long userId) throws Exception;
}

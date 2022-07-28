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
	List<Employee> search(String userName);
	
	
	/**
	 * @param employee
	 * @throws Exception
	 */
	void create(Employee employee) throws Exception;
	/**
	 * @param employerid
	 * @return
	 * @throws Exception
	 */
	Employee read(Integer employerid) throws Exception;
	/** met à jour un employee
	 * @param employee
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Employee update(Employee employee,Integer id) throws Exception;
	/** suprime un employee
	 * @param id
	 */
	void delete(Integer id);
	
	/** attribue une tache à un Employee
	 * @param taskId
	 * @param userId
	 * @throws Exception
	 */
	void taskToUser(Integer taskId, Integer userId) throws Exception;
}

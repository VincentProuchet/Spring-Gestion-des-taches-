package com.gdt.service;

import java.util.List;

import com.gdt.entities.Employee;

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
	 * @param userName
	 * @return
	 */
	List<Employee> search(String userName);
	
	
	/**
	 * @param employee
	 * @throws Exception
	 */
	void create(Employee employee) ;
	/**
	 * @param employerid
	 * @return
	 * @throws Exception
	 */
	Employee read(Integer employerid) ;
	/** met à jour un employee
	 * @param employee
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Employee update(Employee employee,Integer id) ;
	/** suprime un employee
	 * @param id
	 */
	void delete(Integer id);
	
	/** attribue une tache à un Employee
	 * @param taskId
	 * @param userId
	 * @throws Exception
	 */
	void taskToUser(Integer taskId, Integer userId) ;
	Employee getByUSerName(String userName);
}

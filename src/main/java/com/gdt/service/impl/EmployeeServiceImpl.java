package com.gdt.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gdt.entities.Employee;
import com.gdt.entities.Task;
import com.gdt.exceptions.BadRequestException;
import com.gdt.exceptions.ErrorCodes;
import com.gdt.repository.EmployeeRepository;
import com.gdt.service.EmployeeService;
import com.gdt.service.TaskService;

import lombok.extern.slf4j.Slf4j;

/** Implementation de EmployeeService 
 * le découplage est fait pour limiter la dépendance entre un controleur et un service
 * 
 * @author Vincent 
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

	/** repository */
	private EmployeeRepository repository;
	/** taskService */
	private TaskService taskService;

	/** Constructeur
	 * @param repository
	 * @param taskService
	 * 
	 * oui il suffit d'ajouter une propriété et de créer le constructeur pour qu'il puisse juste s'en servir
	 * à ce stade c'est de la magie 
	 */
	public EmployeeServiceImpl(EmployeeRepository repository, TaskService taskService) {
		super();
		this.repository = repository;
		this.taskService = taskService;
	}

	/** retourne tous les résultats
	 * trouvé dans le stockage
	 *
	 */
	@Override
	public List<Employee> search() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	/** persiste un nouvel utilisateur
	 *
	 */
	@Override
	public void create(Employee employee) throws Exception {
		Optional<Employee> current = repository.findByUserName(employee.getUserName());
		if (current.isPresent()) {
			throw new BadRequestException("cet email existe déjà", ErrorCodes.USER_ALLREADY_EXIST);
		}
		repository.save(employee);
	}

	/**	
	 *
	 */
	@Override
	public Employee read(Long id) throws BadRequestException {
		return repository.findById(id)
				.orElseThrow(() -> new BadRequestException("l'utilisateur n'existe pas", ErrorCodes.USER_NOT_FOUND));
	}

	@Override
	public Employee update(Employee employee, Long id) throws Exception {
		Employee current = this.read(id);
		current.setFirstName(employee.getFirstName());
		current.setLastName(employee.getLastName());
		return current;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Transactional
	@Override
	public void taskToUser(Long taskId, Long userId) throws Exception {
		Employee currentEmployee = this.read(userId);
		Task currentTask = taskService.read(taskId);

		if (currentEmployee.getTasks().stream().filter((t) -> t.getId().equals(taskId)).findAny()
				.orElse(null) == null) {
			currentEmployee.getTasks().add(currentTask);

		}
		else {
			throw new BadRequestException("Tache déjà assignée",ErrorCodes.DATA_INTEGRITY_PROTECTION );
		}

	}

}

package com.gdt.entities;

import com.gdt.entities.Task;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Vincent
 *
 */
@Entity
@Table(name = "EMPLOYEE")
@Setter
@Getter
@NoArgsConstructor
public class Employee {
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Long id;
	/** firstName */
	@Column(length = 20)
	private String firstName;
	/** lastName */
	@Column(length = 45)
	private String lastName;
	/** userName */
	@Column(length = 80, unique = true, nullable = false)
	private String userName;

	/** tasks */
	@ManyToMany(fetch = FetchType.EAGER)
	@Setter(value = AccessLevel.NONE)
	private Set<Task> tasks = new HashSet<>();

	/** Constructeur
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param tasks
	 */
	public Employee(Long id, String firstName, String lastName, String userName, HashSet<Task> tasks) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		if (tasks != null) {
			this.tasks = tasks;
		}
	}

	/**
	 * Setter
	 * 
	 * @param tasks the tasks to set
	 */
	public void setTasks(List<Task> tasks) {
		this.tasks.clear();
		this.tasks.addAll(tasks);
	}

}

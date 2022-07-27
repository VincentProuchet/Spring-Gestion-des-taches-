package com.gdt.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Vincent
 *
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** firstName */
	@Column(length = 20)
	private String firstName;
	/** lastName */
	@Column(length = 45)
	private String lastName;
	/** userName */
	@Column(length = 25)
	private String userName;

	/** tasks */
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Task> tasks = new ArrayList<>();

	public Employee() {
		super();
	}

	public Employee(Long id, String firstName, String lastName, String userName, List<Task> tasks) {
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
	 * Getter
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Getter
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Getter
	 * 
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Getter
	 * 
	 * @return the tasks
	 */
	public List<Task> getTasks() {
		return tasks;
	}

	/**
	 * Setter
	 * 
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Setter
	 * 
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Setter
	 * 
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Setter
	 * 
	 * @param tasks the tasks to set
	 */
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}

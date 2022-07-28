package com.gdt.entities;

import com.fasterxml.jackson.core.sym.Name;
import com.gdt.entities.Task;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class Employee implements UserDetails {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Integer id;
	/** firstName */
	@Column(length = 20)
	private String firstName;
	/** lastName */
	@Column(length = 45)
	private String lastName;
	/** userName */
	@Column(length = 80, unique = true, nullable = false)
	@Getter(value = AccessLevel.NONE)

	private String userName;
	//// authentification
	/** password */
	@Column(name = "password", length = 255)
	@Getter (value = AccessLevel.NONE)
	private String password;
	private String token;
	@Column(name = "active")
	private boolean enable;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_roles")
	private Set<Role> roles = new HashSet<>();

	/** tasks */
	@ManyToMany(fetch = FetchType.EAGER)
	@Setter(value = AccessLevel.NONE)
	@JoinTable(name = "users_tasks")
	private Set<Task> tasks = new HashSet<>();

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param tasks
	 */
	public Employee(Integer id, String firstName, String lastName, String userName, HashSet<Task> tasks) {
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return this.roles.stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getLabel()))
				.collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.enable;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.enable;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.enable;
	}

	@Override
	public boolean isEnabled() {
		return this.enable;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}

}

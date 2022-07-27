package com.gdt.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vincent
 *
 */
@Entity
@Table(name = "TASK")
public class Task {
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/** title */
	@Column(length = 20)
	private String title;
	/** description */
	@Column(length = 45)
	private String description;

	/** initial time */
	private int it;
	/** temps restant */
	private int rt;

	/** Constructeur
	 * 
	 */
	public Task() {
		super();
	}

	public Task(Long id, String title, String description, int it, int rt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.it = it;
		this.rt = rt;
	}

	/** Getter
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/** Getter
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/** Getter
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/** Getter
	 * @return the it
	 */
	public int getIt() {
		return it;
	}

	/** Getter
	 * @return the rt
	 */
	public int getRt() {
		return rt;
	}

	/** Setter
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/** Setter
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** Setter
	 * @param it the it to set
	 */
	public void setIt(int it) {
		this.it = it;
	}

	/** Setter
	 * @param rt the rt to set
	 */
	public void setRt(int rt) {
		this.rt = rt;
	}
	
}
	
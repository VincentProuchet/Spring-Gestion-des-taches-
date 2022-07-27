package com.gdt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Vincent
 *
 */

@Entity
@Table(name = "TASK")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Long id;
	/** title */
	@Column(length = 20)
	private String title;
	/** description */
	private String description;

	/** initial time */
	private int it;
	/** temps restant */
	private int rt;

}
	
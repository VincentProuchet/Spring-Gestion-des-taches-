package com.gdt.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CONFIRMATION_TOKEN")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConfirmationToken {
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Integer id;
	
	private String value;
	
	private Instant creation;
	@OneToOne
	private Employee employee;
	
	
}

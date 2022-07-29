package com.gdt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO{
	/** code */
	private String code;
	/** message */
	private String message;
	
	
}

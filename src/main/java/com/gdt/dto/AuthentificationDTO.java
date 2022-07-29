package com.gdt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Vincent
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthentificationDTO {

	private String userName;
	private String password;
	
}

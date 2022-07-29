package com.gdt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Vincent
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
	/** authenfication */
	private String authenfication;
	/** refresh */
	private String refresh;
}

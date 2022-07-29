package com.gdt.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**	Exception spécifique de communication avec l'utilisateur final UF
 * 
 * @author Vincent
 *
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BadRequestException extends RuntimeException {
	private String message;
	private ErrorCodes code;
	
}

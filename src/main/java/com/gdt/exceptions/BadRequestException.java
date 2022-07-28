package com.gdt.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BadRequestException extends Exception {
	private String message;
	private ErrorCodes code;
	
}

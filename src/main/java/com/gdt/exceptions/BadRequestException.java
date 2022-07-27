package com.gdt.exceptions;

public class BadRequestException extends Exception {
	private String message;
	private ErrorCodes code;
	
	
	public BadRequestException() {
		super();
		// TODO Auto-generated constructor stub
	}




	public BadRequestException(String message, ErrorCodes code) {
		super();
		this.message = message;
		this.code = code;
	}




	/** Getter
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}




	/** Getter
	 * @return the code
	 */
	public ErrorCodes getCode() {
		return code;
	}


		
	

}

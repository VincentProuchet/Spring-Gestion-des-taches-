package com.gdt.dto;

public class ErrorDTO{
	private String code;
	private String message;
	public ErrorDTO() {
		super();
	}
	public ErrorDTO(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	/** Getter
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/** Getter
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/** Setter
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/** Setter
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

package com.gdt.service;

import com.gdt.entities.ConfirmationToken;
import com.gdt.entities.Employee;
import com.gdt.exceptions.BadRequestException;

public interface ConfirmationService {
	public void sendEmployeeVerificationToken(Employee employee);
	public ConfirmationToken findToken(String token) throws Exception;
	public void confirmEmployeeRegistration(Employee employee, ConfirmationToken token) throws BadRequestException;
	
}

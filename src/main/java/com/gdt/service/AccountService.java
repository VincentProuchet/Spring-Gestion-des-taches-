package com.gdt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gdt.entities.Employee;
import com.gdt.exceptions.BadRequestException;

public interface AccountService extends  UserDetailsService{
	public void signUp(Employee employe) throws Exception;
	public void validate(String token) throws Exception;
}

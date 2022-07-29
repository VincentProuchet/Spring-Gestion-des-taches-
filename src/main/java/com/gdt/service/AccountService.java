package com.gdt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gdt.dto.AuthentificationDTO;
import com.gdt.dto.TokenDTO;
import com.gdt.entities.Employee;

public interface AccountService extends  UserDetailsService{
	public void signUp(Employee employe);
	public void validate(String token) ;
	public TokenDTO generateTokens(AuthentificationDTO authentificationDTO);
}

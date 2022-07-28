package com.gdt.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gdt.entities.Employee;
import com.gdt.exceptions.BadRequestException;
import com.gdt.service.AccountService;

import lombok.AllArgsConstructor;
@RestController
@AllArgsConstructor
public class AccountController {

	AccountService service;
	
	@PostMapping(path="signup", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void signUp(@RequestBody Employee employee) throws Exception {

		service.signUp(employee);
		
		
	}
	@PostMapping(path="signup/batch", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void signUp(@RequestBody Employee[] employees) throws Exception {
		for (Employee employee : employees) {
			service.signUp(employee);
		}
		
		
	}
	
	@GetMapping(path ="validate/{token}")
	public void validate(@PathVariable String token) throws Exception {
		service.validate(token);
	}
	
	
	
}

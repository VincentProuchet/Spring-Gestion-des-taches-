package com.gdt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gdt.dto.AuthentificationDTO;
import com.gdt.dto.TokenDTO;
import com.gdt.entities.Employee;
import com.gdt.service.AccountService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AccountController {

	private AccountService accountService;
	private AuthenticationManager authenticationManager;

	@PostMapping(path = "signup", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void signUp(@RequestBody Employee employee) throws Exception {

		accountService.signUp(employee);

	}

	@PostMapping(path = "signin", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public @ResponseBody TokenDTO signIn(@RequestBody AuthentificationDTO autentication) throws Exception {
		// on récupérer les données de connexion entrées par l'utilisateur lors du login
		// Spring
		this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(autentication.getUserName(), autentication.getPassword()));
		// generer token

		return this.accountService.generateTokens(autentication);
	}

	@PostMapping(path = "signup/batch", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void signUp(@RequestBody Employee[] employees) throws Exception {
		for (Employee employee : employees) {
			accountService.signUp(employee);
		}

	}

	@GetMapping(path = "validate/{token}")
	public void validate(@PathVariable String token) throws Exception {
		accountService.validate(token);
	}

}

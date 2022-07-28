package com.gdt.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gdt.entities.ConfirmationToken;
import com.gdt.entities.Employee;
import com.gdt.entities.Role;
import com.gdt.enums.UserRole;
import com.gdt.exceptions.BadRequestException;
import com.gdt.exceptions.ErrorCodes;
import com.gdt.repository.RoleRepository;
import com.gdt.service.AccountService;
import com.gdt.service.ConfirmationService;
import com.gdt.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

	private RoleRepository roles;
	private BCryptPasswordEncoder passwordEncoder;
	private EmployeeService employeeService;
	private ConfirmationService confirmationService;

	@Override
	public void signUp(Employee employe) throws Exception {

		if (employe.getPassword() == null || employe.getPassword().length() < 8) {
			throw new BadRequestException("mode de passe invalide ", ErrorCodes.DATA_INTEGRITY_PROTECTION);

		}
		log.error("message");

		String encodedPassword = passwordEncoder.encode(employe.getPassword());
		employe.setPassword(encodedPassword);
		employe.setEnable(false);
		Role role = this.roles.findByLabel(UserRole.USER).orElse(null);
		employe.getRoles().add(role);
		employeeService.create(employe);
		confirmationService.sendEmployeeVerificationToken(employe);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

	@Override
	public void validate(String token) throws Exception {
		ConfirmationToken currentToken = confirmationService.findToken(token);
	
		confirmationService.confirmEmployeeRegistration(currentToken.getEmployee(), currentToken);

	}

}

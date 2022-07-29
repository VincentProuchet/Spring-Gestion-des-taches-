package com.gdt.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gdt.dto.AuthentificationDTO;
import com.gdt.dto.TokenDTO;
import com.gdt.entities.Employee;
import com.gdt.entities.Role;
import com.gdt.entities.SecurityToken;
import com.gdt.enums.UserRole;
import com.gdt.exceptions.BadRequestException;
import com.gdt.exceptions.ErrorCodes;
import com.gdt.repository.RoleRepository;
import com.gdt.security.JWTTokenUtils;
import com.gdt.service.AccountService;
import com.gdt.service.ConfirmationService;
import com.gdt.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Vincent
 *
 */
@Slf4j
@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

	/** roles */
	private RoleRepository roles;
	/** passwordEncoder */
	private BCryptPasswordEncoder passwordEncoder;
	/** employeeService */
	private EmployeeService employeeService;
	/** confirmationService */
	private ConfirmationService confirmationService;
	
	
	private JWTTokenUtils jwtToken;

	/**
	 *
	 */
	@Override
	public void signUp(Employee employe) {

		if (employe.getPassword() == null || employe.getPassword().length() < 8) {
			throw new BadRequestException("mode de passe invalide ", ErrorCodes.DATA_INTEGRITY_PROTECTION);

		}

		String encodedPassword = passwordEncoder.encode(employe.getPassword());
		employe.setPassword(encodedPassword);
		employe.setEnable(false);
		Role role = this.roles.findByLabel(UserRole.USER).orElse(null);
		employe.getRoles().add(role);
		employeeService.create(employe);
		confirmationService.sendEmployeeVerificationToken(employe);
		log.info("Nouvel Utilisateur Crée");

	}

	/**
	 *
	 */
	@Override
	public UserDetails loadUserByUsername(String username)  {
		return this.employeeService.getByUSerName(username);
	}

	/**
	 *
	 */
	@Override
	public void validate(String token)  {
	
		confirmationService.confirmEmployeeRegistration( token);

	}
	
	
	public TokenDTO generateTokens(AuthentificationDTO authentificationDTO) {
		
		Employee employee = this.employeeService.getByUSerName(authentificationDTO.getUserName());
		TokenDTO token = new TokenDTO();
		token.setAuthenfication(this.jwtToken.generateToken(employee));
		token.setRefresh(RandomStringUtils.random(200,true,true) );
		
		// stocker le token dans la base de donnée 
		SecurityToken Stoken= new SecurityToken();
		Stoken.setAuthentification(token.getAuthenfication());
		Stoken.setRefresh(token.getRefresh());
		Stoken.setEmployee(employeeService.getByUSerName(authentificationDTO.getUserName()) );
		
		
		return token;
		
	}

}

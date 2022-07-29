package com.gdt.service.impl;

import java.time.Instant;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.gdt.entities.ConfirmationToken;
import com.gdt.entities.Employee;
import com.gdt.exceptions.BadRequestException;
import com.gdt.exceptions.ErrorCodes;
import com.gdt.repository.ConfirmationTokenRepository;
import com.gdt.service.ConfirmationService;

import lombok.AllArgsConstructor;


/**
 * @author Vincent
 *
 */
@Service
@AllArgsConstructor
public class ConfirmationServiceImp implements ConfirmationService{

	/** confirmationTokenRepository */
	ConfirmationTokenRepository confirmationTokenRepository;
	/**
	 *
	 */
	@Override
	public void sendEmployeeVerificationToken(Employee employee) {
		// générer un token
		String validationToken = RandomStringUtils.random(6,false,true);
		
		// sauvegarder le token dans la base
		ConfirmationToken token = new ConfirmationToken();
		token.setValue(validationToken);
		token.setEmployee(employee);
		token.setCreation(Instant.now());
		this.confirmationTokenRepository.save(token);
		
		// envoyer le token SMS/mail
		
		
	}

	/**
	 *
	 */
	public void confirmEmployeeRegistration( String token) {
		if(token!=null) {
			 
			ConfirmationToken confirmedtoken = confirmationTokenRepository.findByValue(token).orElseThrow(()-> new BadRequestException("Token non valide",ErrorCodes.DATA_INTEGRITY_PROTECTION));
			confirmedtoken.getEmployee().setEnable(true);
			confirmationTokenRepository.delete(confirmedtoken);			
		}
		throw new BadRequestException("token Null",ErrorCodes.DATA_INTEGRITY_ERROR);
		

		
		
	}
	
}

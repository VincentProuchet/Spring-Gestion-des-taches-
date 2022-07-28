package com.gdt.service.impl;

import java.time.Instant;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.gdt.entities.ConfirmationToken;
import com.gdt.entities.Employee;
import com.gdt.exceptions.BadRequestException;
import com.gdt.repository.ConfirmationTokenRepository;
import com.gdt.service.ConfirmationService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ConfirmationServiceImp implements ConfirmationService{

	ConfirmationTokenRepository confirmationTokenRepository;
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
	public void confirmEmployeeRegistration(Employee employee, ConfirmationToken token) throws BadRequestException {
		if(token!=null) {
			
			ConfirmationToken confirmedtoken = confirmationTokenRepository.findByValueAndEmployeeId(token.getValue(), employee.getId()).orElseThrow(()-> new BadRequestException());
			employee.setEnable(true);
			confirmationTokenRepository.delete(confirmedtoken);			
		}
		

		
		
	}
	@Override
	public ConfirmationToken findToken(String value) throws Exception {
		
		return confirmationTokenRepository.findByValue(value).orElseThrow(()->new BadRequestException() );
			}
		


}

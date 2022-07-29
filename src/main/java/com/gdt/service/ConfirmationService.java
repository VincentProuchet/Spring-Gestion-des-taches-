package com.gdt.service;

import com.gdt.entities.ConfirmationToken;
import com.gdt.entities.Employee;
import com.gdt.exceptions.BadRequestException;

/**
 * @author Vincent
 *
 */
public interface ConfirmationService {
	/** enregistre le signUp et 
	 * 	effectue les procédures d'enregistrement d'un nouvel utilisateur et 
	 *  envoie le mail de confirmation d'inscription
	 * 
	 * @param employee
	 */
	public void sendEmployeeVerificationToken(Employee employee);

	/**	cherche et récupére le token 
	 * valide l'activation du compte 
	 * supprime le token devenu inutile
	 * 	
	 * @param employee
	 * @param token
	 */
	public void confirmEmployeeRegistration(String token) ;
	
}

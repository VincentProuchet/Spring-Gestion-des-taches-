package com.gdt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdt.entities.ConfirmationToken;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Integer> {
	/**
	 * SELect * from confirmationToken ct join employee e on e.id = ct.user_id where
	 * ct.valuer and e.username = :username
	 * 
	 * @param value
	 * @param username
	 * @return
	 */
	Optional<ConfirmationToken> findByValueAndEmployeeUserName(String value, String username);

	Optional<ConfirmationToken> findByValueAndEmployeeId(String value, Integer id);
	
	Optional<ConfirmationToken> findByValue(String value);
}

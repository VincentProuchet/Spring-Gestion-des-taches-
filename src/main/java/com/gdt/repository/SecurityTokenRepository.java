package com.gdt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdt.entities.SecurityToken;

public interface SecurityTokenRepository extends JpaRepository<SecurityToken, Integer> {

	
}

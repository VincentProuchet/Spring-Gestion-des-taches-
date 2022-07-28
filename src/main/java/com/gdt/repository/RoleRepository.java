package com.gdt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdt.entities.Role;
import com.gdt.enums.UserRole;

public interface RoleRepository  extends JpaRepository<Role, Integer>{
Optional<Role>findByLabel(UserRole label);
}

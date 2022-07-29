package com.gdt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdt.entities.Role;
import com.gdt.enums.UserRole;

/** ces repository son des interface que Spring vas implémenter tous seul comme un grand 
 * 
 * @author Vincent
 *
 */
public interface RoleRepository  extends JpaRepository<Role, Integer>{
	
	
/** si il implement des fonction de base
 * on peux en ajouter
 * mais le nom des methodes DOIT être significatif 
 * et les variables correspsondre au nom donnés aux propriété de l'entity 
 * qu'il vas devoir manipuler
 * 
 * @param label
 * @return
 */
Optional<Role>findByLabel(UserRole label);
}

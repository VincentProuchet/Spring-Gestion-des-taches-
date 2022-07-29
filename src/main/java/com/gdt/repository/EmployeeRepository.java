package com.gdt.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gdt.entities.Employee;

/**
 * ces repository son des interface que Spring vas implémenter tous seul comme
 * un grand
 * 
 * @author Vincent
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Optional<Employee> findByUserName(String userName);

	/**
	 * si il implement des fonction de base on peux en ajouter mais le nom des
	 * methodes DOIT être significatif et les variables correspsondre au nom donnés
	 * aux propriété de l'entity qu'il vas devoir manipuler
	 * 
	 * @param username
	 * @return
	 * 
	 * Ici on vas carrément lui fournir une requete. notez qu'il s'agit de JPQL
	 */
	@Query("SELECT e FROM Employee e WHERE e.userName LIKE CONCAT('%',:username,'%')")
	Stream<Employee> search(@Param("username") String username);

}

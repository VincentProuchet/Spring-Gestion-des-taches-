package com.gdt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdt.entities.Task;

/** celui-ci est vide
 * parce que y'a rien de plus à y mettre si on a pas de besoins spécifiques
 * @author Vincent
 *
 */
public interface TaskRepository  extends JpaRepository<Task, Integer>{

}

package com.gdt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdt.entities.Task;

public interface TaskRepository  extends JpaRepository<Task, Long>{

}

-- liquibase formatted sql

-- changeset Vincent:1
CREATE TABLE employee(
	
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	-- @Column(length = 20)
	 `first_name` VARCHAR(20),
	-- @Column(length = 45)
	  `last_name` VARCHAR(45),
	-- @Column(length = 80, unique = true, nullable = false)
	  `user_name` VARCHAR(80) UNIQUE NOT NULL
	)
CREATE TABLE task(

	`id`  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	-- /** title */
	-- @Column(length = 20)
	`title` VARCHAR,
	-- /** description */
	`description` VARCHAR,
	-- /** initial time */
	`it` INT,
	-- /** temps restant */
	`rt` INT,
	
	)
	
	-- changeset Vincent:2
	
	ALTER TABLE employee add column password varchar(255);
	-- cchangeset Vincent:3
	ALTER TABLE employee add column active boolean ;
	
	--changeset Vincent:4
	CREATE TABLE role(
		id INT NOT NULL  AUTO_INCREMENT PRIMARY KEY,
		label VARCHAR (20)
	
	)
	
	
	CREATE TABLE employe_role(
	employee_id INT,
	role_id INT,
	PRIMARY KEY (employee_id, role_id),
	FOREIGN KEY (employee_id, employee.id),
		FOREIGN KEY (role_id, role.id),
		
	)
	
	-- changeset  vincent:5
	INSERT INTO role(label VALUES ('ADMIN');
		INSERT INTO role(label VALUES ('USER');
			INSERT INTO role(label VALUES ('MANAGER');
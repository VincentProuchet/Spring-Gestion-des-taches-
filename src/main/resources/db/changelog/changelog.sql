-- liquibase formatted sql

-- changeset Vincent:1
CREATE TABLE employee(
	-- @GeneratedValue(strategy = GenerationType.IDENTITY)
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	-- @Column(length = 20)
	 `first_name` VARCHAR(20),
	-- @Column(length = 45)
	  `last_name` VARCHAR(45),
	-- @Column(length = 80, unique = true, nullable = false)
	  `user_name` VARCHAR(80) UNIQUE NOT NULL,
	)
CREATE TABLE task(
	-- @GeneratedValue(strategy = GenerationType.IDENTITY)
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
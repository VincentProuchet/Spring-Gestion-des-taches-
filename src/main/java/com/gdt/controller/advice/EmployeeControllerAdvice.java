package com.gdt.controller.advice;



import java.sql.SQLIntegrityConstraintViolationException;

import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gdt.dto.ErrorDTO;
import com.gdt.exceptions.BadRequestException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@ControllerAdvice
public class EmployeeControllerAdvice {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = SQLIntegrityConstraintViolationException.class )
	public @ResponseBody ErrorDTO handleSQLIntegrityConstraintViolationException(Exception exception) {
		exception.printStackTrace();
		ErrorDTO error = new ErrorDTO();
		error.setCode("ERR_EMAIL_ALLREADY_EXIST");
		error.setMessage(exception.getMessage());
		return error;
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = BadRequestException.class )
	public @ResponseBody ErrorDTO handleBadRequestException(BadRequestException exception) {
		log.error("message", exception);


		ErrorDTO error = new ErrorDTO();
		error.setCode(exception.getCode().toString());
		error.setMessage(exception.getMessage());
		return error;
	}

}

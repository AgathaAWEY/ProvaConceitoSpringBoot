package com.spring.web.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.web.services.exceptions.DataIntegrityException;
import com.spring.web.services.exceptions.ObjectNotFoundException;


/**
 * Classe ResourceExceptionHandler
 * Que tem como objetico interceptar as excecoes
 * 
 * @author agatha
 *
 */
@ControllerAdvice
public class ResourceExceptionHandler {

	/**
	 * Metodo que trata a excecao do tipo ObjectNotFoundException
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,  HttpServletRequest request) {
		
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	
	/**
	 * Metodo que trata a excecao do tipo DataIntegrityException
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> objectNotFound(DataIntegrityException e,  HttpServletRequest request) {
		
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}


}

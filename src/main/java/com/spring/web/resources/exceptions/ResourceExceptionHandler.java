package com.spring.web.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.web.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
/**
 * Classe ResourceExceptionHandler
 * Que tem como objetico interceptar as excecoes
 * @author agatha
 *
 */
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

}

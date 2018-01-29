package com.spring.web.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.domain.Card;
import com.spring.web.services.CardService;

/**
 * Controlador Rest 
 */
@RestController
@RequestMapping(value="/cards")
public class CardResource {

	@Autowired
	private CardService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Card obj = service.search(id);
		return ResponseEntity.ok().body(obj);

	}
	
}

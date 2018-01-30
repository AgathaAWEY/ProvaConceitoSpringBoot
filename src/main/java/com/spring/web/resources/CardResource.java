package com.spring.web.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.web.domain.Card;
import com.spring.web.services.CardService;

/**
 * Rest Card Controller
 */
@RestController
@RequestMapping(value="/cards")
public class CardResource {

	@Autowired
	private CardService service;
	
			
	/**
	 * Find by ID
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Card> find(@PathVariable Integer id) {
		Card obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/**
	 * Insert Card
	 * @param obj
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Card obj) {
		obj = service.insert(obj);
		
		/* Boa Pratica: 
		 * No protocolo http quando executa com sucesso uma cricao, 
		 * utiliza-se o codigo 201 - ok 
		 * e tem que fornecer a URI como resposta na requisicao */
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				 	.path("/{id}")
				 	.buildAndExpand(obj.getId())
				 	.toUri();
		 
		 return ResponseEntity.created(uri).build();
	}
	
	/**
	 * Update Card
	 * @param obj
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Card obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}	
	
	
	/**
	 * Delete Card
	 * @param obj
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
			
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

	/**
	 * Find by ID
	 * @param id
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Card>> findAll() {
		List<Card> cards = service.findAll();
		
		return ResponseEntity.ok().body(cards);
	}
}

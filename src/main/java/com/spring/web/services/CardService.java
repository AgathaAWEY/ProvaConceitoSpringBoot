package com.spring.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.domain.Card;
import com.spring.web.repositories.CardRepository;
import com.spring.web.services.exceptions.ObjectNotFoundException;

/**
 * Card Service
 * @author agatha
 *
 */
@Service
public class CardService {

	@Autowired 
	private CardRepository repository;
	
	/**
	 * Search Card by ID
	 * @param id
	 * @return
	 */
	public Card search(Integer id) {
		Card cardObj = repository.findOne(id);

		if (cardObj == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado! id: " + id
					+ " do Tipo: " + Card.class.getName()); 
		}
		
		return cardObj;
	}
	
}

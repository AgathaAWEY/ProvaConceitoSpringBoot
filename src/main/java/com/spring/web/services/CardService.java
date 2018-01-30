package com.spring.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.spring.web.domain.Card;
import com.spring.web.repositories.CardRepository;
import com.spring.web.services.exceptions.DataIntegrityException;
import com.spring.web.services.exceptions.ObjectNotFoundException;

/**
 * Card Service
 * 
 * @author agatha
 *
 */
@Service
public class CardService {

	@Autowired 
	private CardRepository repository;
	
	/**
	 * Search Card by ID
	 * 
	 * @param id
	 * @return
	 */
	public Card find(Integer id) {
		Card cardObj = repository.findOne(id);

		if (cardObj == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado! id: " + id
					+ " do Tipo: " + Card.class.getName()); 
		}
		return cardObj;
	}

	/**
	 * Insert Card
	 * 
	 * @param obj
	 * @return
	 */
	public Card insert(Card obj) {
		obj.setId(null);
		
		return repository.save(obj);
	}
	
	/**
	 * Update Card
	 * 
	 * @param obj
	 * @return
	 */
	public Card update(Card obj) {

		find(obj.getId());
		
		return repository.save(obj);
	}
	
	/**
	 * Delete Card
	 * 
	 * @param obj
	 * @return
	 */
	public void delete(Integer id) {

		this.find(id);
		
		try {
			repository.delete(id);
		
		} catch (DataIntegrityViolationException e) {
			
			// Excecao personalizada da camada de servicos
			throw new DataIntegrityException("Nao e possivel excluir um cartao que possui relacao com outro dominio. Por favor verificar.");
		}
	}
	
	
	/**
	 * Find All Cards
	 * @return
	 */
	public List<Card> findAll() {
		
		return repository.findAll();
	}
	
}

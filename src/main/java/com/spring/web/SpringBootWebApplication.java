package com.spring.web;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.web.domain.Card;
import com.spring.web.domain.FinancialInstitution;
import com.spring.web.repositories.CardRepository;
import com.spring.web.repositories.FinancialInstitutionRepository;

@SpringBootApplication
public class SpringBootWebApplication implements CommandLineRunner{

	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private FinancialInstitutionRepository financialRepository;
		
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

	
	/**
	 * Ao iniciar a app vai instanciar os objetos abaixo
	 * @param arg0
	 * @throws Exception
	 */
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub

		FinancialInstitution financial1 = new FinancialInstitution(null, "Bank1", "1001");
		FinancialInstitution financial2 = new FinancialInstitution(null, "Bank2", "1002");
				
		Card card1 = new Card(null, "Card Visa", "001", financial1);
		Card card2 = new Card(null, "Card Master", "002", financial2);
	
		financial1.setCards(Arrays.asList(card1));
		financial2.setCards(Arrays.asList(card2));
		
		/** Salvar as cards no database */
		financialRepository.save(Arrays.asList(financial1, financial2));
		cardRepository.save(Arrays.asList(card1, card2));
	}
		
}


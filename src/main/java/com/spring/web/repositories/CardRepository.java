package com.spring.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.web.domain.Card;


/**
 * Classe capaz de fazer consulta e acessar os dados do cartao
 * @author agatha
 *
 */
@Repository
public interface CardRepository extends JpaRepository<Card, Integer>{

}

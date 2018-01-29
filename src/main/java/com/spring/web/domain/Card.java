package com.spring.web.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe de dominio Card
 */
@Entity
public class Card implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String bin;
		
	@ManyToOne
	@JoinColumn(name="Financial_id")
	private FinancialInstitution financialInstitution;
	
	
	/**
	 * The Constructor
	 **/
	public Card() {
		
	}

	/**
	 * The Constructor
	 * @param id
	 * @param name
	 * @param bin
	 * @param financialInstitution
	 */
	public Card(Integer id, String name, String bin, FinancialInstitution financialInstitution) {
		super();
		this.id = id;
		this.name = name;
		this.bin = bin;
		this.financialInstitution = financialInstitution;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBin() {
		return bin;
	}
	public void setBin(String bin) {
		this.bin = bin;
	}
	public FinancialInstitution getFinancialInstitution() {
		return financialInstitution;
	}
	public void setFinancialInstitution(FinancialInstitution financialInstitution) {
		this.financialInstitution = financialInstitution;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

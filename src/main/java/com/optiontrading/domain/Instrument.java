/**
 * 
 */
package com.optiontrading.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author telberrak
 *
 */
@Entity
@Table(name="instruments")
@NamedQuery(name = "Instrument.findByTicker", query = "from Instrument u where u.ticker = ?1")
public class Instrument {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String ticker;

	
	Instrument(Long id)
	{
		this.setId(id);
	}

	Instrument(Long id, String ticker)
	{
		this.setId(id);
		this.setTicker(ticker);
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTicker() {
		return ticker;
	}


	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	
}

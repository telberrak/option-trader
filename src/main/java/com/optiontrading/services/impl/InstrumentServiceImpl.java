/**
 * 
 */
package com.optiontrading.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optiontrading.domain.Instrument;
import com.optiontrading.repositories.InstrumentRepository;
import com.optiontrading.services.InstrumentService;

/**
 * @author telberrak
 *
 */
@Service
public class InstrumentServiceImpl implements InstrumentService {

	@Autowired
	private InstrumentRepository instrumentRepository;

	/**
	 * 
	 */
	public InstrumentServiceImpl() {

	}

	public List<Instrument> retrieveAllInstruments() {

		List<Instrument> instruments = new ArrayList<Instrument>();
		instrumentRepository.findAll().forEach(instruments::add);

		return instruments;

	}

}

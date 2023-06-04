/**
 * 
 */
package com.optiontrading.services;

import java.util.List;

import com.optiontrading.domain.Instrument;

/**
 * @author telberrak
 *
 */
public interface InstrumentService {
	
	List<Instrument> retrieveAllInstruments();

}

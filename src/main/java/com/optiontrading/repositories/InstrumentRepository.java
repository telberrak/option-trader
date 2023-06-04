/**
 * 
 */
package com.optiontrading.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.optiontrading.domain.Instrument;

/**
 * @author telberrak
 *
 */
@Repository
public interface InstrumentRepository extends CrudRepository<Instrument, Long> {

}

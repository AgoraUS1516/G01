package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.RecuentoGeneral;


import repositories.RecuentoGeneralRepository;

@Service
@Transactional
public class RecuentoGeneralService {
	
	// Managed repository -------------------------------------------------

	@Autowired
	private RecuentoGeneralRepository recuentoGeneralRepository;
	
// Supporting Service -------------------------------------------------

// Constructor -------------------------------------------------
	public RecuentoGeneralService(){
		super();
	}
	// Simple CRUD methods -------------------------------------------------
	public RecuentoGeneral create() {
		RecuentoGeneral o = new RecuentoGeneral();
		return o;	
	}

	public RecuentoGeneral findOne(int recuentoGeneralId) {
		RecuentoGeneral result = recuentoGeneralRepository.findOne(recuentoGeneralId);
		Assert.notNull(result);
		return result;
	}

	public Collection<RecuentoGeneral> findAll() {
		Collection<RecuentoGeneral>result = recuentoGeneralRepository.findAll();
		Assert.notNull(result);
		return result;
	}

	public void save(RecuentoGeneral recuentoGeneral) {
		Assert.notNull(recuentoGeneral);
		recuentoGeneralRepository.save(recuentoGeneral);
		
	}

	public void delete(RecuentoGeneral recuentoGeneral) {
		Assert.notNull(recuentoGeneral);
		recuentoGeneralRepository.delete(recuentoGeneral);
	}

	// Other methods -------------------------------------------------
}

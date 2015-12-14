package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.RecuentoCP;
import domain.RecuentoCP;


import repositories.RecuentoCPRepository;

@Service
@Transactional
public class RecuentoCPService {
	
	// Managed repository -------------------------------------------------

	@Autowired
	private RecuentoCPRepository recuentoCPRepository;
	
// Supporting Service -------------------------------------------------

// Constructor -------------------------------------------------
	public RecuentoCPService(){
		super();
	}
	// Simple CRUD methods -------------------------------------------------
	public RecuentoCP create() {
		RecuentoCP o = new RecuentoCP();
		return o;	
	}

	public RecuentoCP findOne(int recuentoCPId) {
		RecuentoCP result = recuentoCPRepository.findOne(recuentoCPId);
		Assert.notNull(result);
		return result;
	}

	public Collection<RecuentoCP> findAll() {
		Collection<RecuentoCP>result = recuentoCPRepository.findAll();
		Assert.notNull(result);
		return result;
	}

	public void save(RecuentoCP recuentoCP) {
		Assert.notNull(recuentoCP);
		recuentoCPRepository.save(recuentoCP);
		
	}

	public void delete(RecuentoCP recuentoCP) {
		Assert.notNull(recuentoCP);
		recuentoCPRepository.delete(recuentoCP);
	}

	// Other methods -------------------------------------------------
}

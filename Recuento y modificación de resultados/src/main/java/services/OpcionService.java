package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Opcion;


import repositories.OpcionRepository;

@Service
@Transactional
public class OpcionService {
	
	// Managed repository -------------------------------------------------

	@Autowired
	private OpcionRepository opcionRepository;
	
// Supporting Service -------------------------------------------------

// Constructor -------------------------------------------------
	public OpcionService(){
		super();
	}
	// Simple CRUD methods -------------------------------------------------
	public Opcion create() {
		Opcion o = new Opcion();
		return o;	
	}

	public Opcion findOne(int opcionServiceId) {
		Opcion result = opcionRepository.findOne(opcionServiceId);
		Assert.notNull(result);
		return result;
	}

	public Collection<Opcion> findAll() {
		Collection<Opcion>result = opcionRepository.findAll();
		Assert.notNull(result);
		return result;
	}

	public void save(Opcion opcionService) {
		Assert.notNull(opcionService);
		opcionRepository.save(opcionService);
		
	}

	public void delete(Opcion opcionService) {
		Assert.notNull(opcionService);
		opcionRepository.delete(opcionService);
	}

	// Other methods -------------------------------------------------
}

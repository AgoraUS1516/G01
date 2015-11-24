package services;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.VotoRepository;

import domain.Voto;

@Service
@Transactional
public class VotoService {
	
	// Managed repository -------------------------------------------------

		@Autowired
		private VotoRepository votoRepository;
		
	// Supporting Service -------------------------------------------------

	// Constructor -------------------------------------------------
	public VotoService() {
		super();
	}
	
	// Simple CRUD methods -------------------------------------------------
		public Voto create() {
			Voto r = new Voto();
			
			return r;	
		}

		public Voto findOne(int votoId) {
			Voto result = votoRepository.findOne(votoId);
			return result;
		}

		public Collection<Voto> findAll() {
			Collection<Voto>result = votoRepository.findAll();
			return result;
		}

		public void save(Voto voto) {
			votoRepository.save(voto);
			
		}

		public void delete(Voto voto) {
			votoRepository.delete(voto);
		}

		// Other methods -------------------------------------------------
}

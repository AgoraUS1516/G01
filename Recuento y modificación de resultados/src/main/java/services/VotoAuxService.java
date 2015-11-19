package services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.VotoAuxRepository;
import domain.Answer;
import domain.VotoAux;

@Service
@Transactional
public class VotoAuxService {
	
	// Managed repository -------------------------------------------------

			@Autowired
			private VotoAuxRepository votoRepository;
			
		// Supporting Service -------------------------------------------------

		// Constructor -------------------------------------------------
		public VotoAuxService() {
			super();
		}
		
		// Simple CRUD methods -------------------------------------------------
			public VotoAux create() {
				VotoAux r = new VotoAux();
				r.setAnswers(new ArrayList<Answer>());
				return r;	
			}

			public VotoAux findOne(int votoAuxId) {
				VotoAux result = votoRepository.findOne(votoAuxId);
				return result;
			}

			public Collection<VotoAux> findAll() {
				Collection<VotoAux>result = votoRepository.findAll();
				return result;
			}

			public void save(VotoAux votoAux) {
				votoRepository.save(votoAux);
				
			}

			public void delete(VotoAux voto) {
				votoRepository.delete(voto);
			}

			// Other methods -------------------------------------------------
	


}

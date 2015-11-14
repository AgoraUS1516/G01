package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Resultado;

import repositories.ResultadoRepository;

@Service
@Transactional
public class ResultadoService {
	
	// Managed repository -------------------------------------------------

		@Autowired
		private ResultadoRepository resultadoRepository;
		
	// Supporting Service -------------------------------------------------

	// Constructor -------------------------------------------------
	public ResultadoService() {
		super();
	}
	
	// Simple CRUD methods -------------------------------------------------
		public Resultado create() {
			Resultado r = new Resultado();
			return r;	
		}

		public Resultado findOne(int resultadoServiceId) {
			Resultado result = resultadoRepository.findOne(resultadoServiceId);
			Assert.notNull(result);
			return result;
		}

		public Collection<Resultado> findAll() {
			Collection<Resultado>result = resultadoRepository.findAll();
			Assert.notNull(result);
			return result;
		}

		public void save(Resultado resultadoService) {
			Assert.notNull(resultadoService);
			resultadoRepository.save(resultadoService);
			
		}

		public void delete(Resultado resultadoService) {
			Assert.notNull(resultadoService);
			resultadoRepository.delete(resultadoService);
		}

		// Other methods -------------------------------------------------
}

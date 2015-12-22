package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Respuesta;

import repositories.RespuestaRepository;

@Service
@Transactional
public class RespuestaService {
	
	// Managed repository -------------------------------------------------

		@Autowired
		private RespuestaRepository respuestaRepository;
		
	// Supporting Service -------------------------------------------------

	// Constructor -------------------------------------------------
	public RespuestaService() {
		super();
	}
	
	// Simple CRUD methods -------------------------------------------------
		public Respuesta create() {
			Respuesta r = new Respuesta();
			return r;	
		}

		public Respuesta findOne(int respuestaServiceId) {
			Respuesta result = respuestaRepository.findOne(respuestaServiceId);
			Assert.notNull(result);
			return result;
		}

		public Collection<Respuesta> findAll() {
			Collection<Respuesta>result = respuestaRepository.findAll();
			Assert.notNull(result);
			return result;
		}

		public void save(Respuesta resultadoService) {
			Assert.notNull(resultadoService);
			respuestaRepository.save(resultadoService);
			
		}

		public void delete(Respuesta resultadoService) {
			Assert.notNull(resultadoService);
			respuestaRepository.delete(resultadoService);
		}

	
		// Other methods -------------------------------------------------
		public Collection<String> getPreguntasDeUnaVotacion(int votacionId) {
			Collection<String> result=respuestaRepository.preguntasDeUnaVotacion(votacionId);
			return result;
		}
		
		public Collection<Integer> getCPsDeUnaVotacion(int votacionId){
			Collection<Integer> result=respuestaRepository.cpsDeUnaVotacion(votacionId);
			return result;
		}
		public Collection<String> getOpcionesPregunta(int votacionId, String pregunta){
			Collection<String> result=respuestaRepository.opcionesDeUnaVotacion(votacionId, pregunta);
			return result;
		}
}

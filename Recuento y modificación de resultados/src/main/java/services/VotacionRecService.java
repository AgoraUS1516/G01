package services;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.google.gson.Gson;

import domain.Recuento;
import domain.RecuentoCP;
import domain.RecuentoGeneral;
import domain.Votacion;
import domain.VotacionRec;

import repositories.VotacionRecRepository;

@Service
@Transactional
public class VotacionRecService {
	
	// Managed repository -------------------------------------------------

		@Autowired
		private VotacionRecRepository votacionRecRepository;

	// Supporting Service -------------------------------------------------
		@Autowired
		private VotacionService votacionService;
		@Autowired
		private RecuentoCPService recuentoCPService ;
		@Autowired
		private RecuentoGeneralService recuentoGeneralService ;
		@Autowired
		private RespuestaService respuestaService ;
		
	// Constructor -------------------------------------------------
	public VotacionRecService() {
		super();
	}
	
	// Simple CRUD methods -------------------------------------------------
		public VotacionRec create() {
			VotacionRec r = new VotacionRec();
			r.setUltimaModififacion(new Date());
			return r;	
		}

		public VotacionRec findOne(int votacionRecServiceId) {
			VotacionRec result = votacionRecRepository.findOne(votacionRecServiceId);
			Assert.notNull(result);
			return result;
		}

		public Collection<VotacionRec> findAll() {
			Collection<VotacionRec>result = votacionRecRepository.findAll();
			Assert.notNull(result);
			return result;
		}

		public void save(VotacionRec votacionRec) {
			Assert.notNull(votacionRec);
			votacionRecRepository.saveAndFlush(votacionRec);
			
		}

		public void delete(VotacionRec votacionRecService) {
			Assert.notNull(votacionRecService);
			votacionRecRepository.delete(votacionRecService);
		}

		// Other methods -------------------------------------------------
//	En el nuevo método le debe entrar una id
 	public VotacionRec recuentaVotos(int votacionId){
			Votacion votacion=votacionService.findOne(votacionId);
			VotacionRec result;
			
			result=create();
			result.setNombre(votacion.getNombre());
			
			List<Recuento> recuentos= new ArrayList<Recuento>();
			
			Collection<String> preguntasVot=respuestaService.getPreguntasDeUnaVotacion(votacionId);
			Collection<Integer> cPs=respuestaService.getCPsDeUnaVotacion(votacionId);

			
			for(String pregunta:preguntasVot){
				
				for(Integer cP:cPs){
					Collection<Object[]> opcionesRecCP=votacionService.recuentaParaUnaDeterminaPreguntaYCP(votacionId, pregunta, cP);
					for(Object[] o:opcionesRecCP){
					 	RecuentoCP recuentoCP=recuentoCPService.create();
						recuentoCP.setCp(cP);
						recuentoCP.setPregunta(pregunta);
						Integer cuenta=Integer.valueOf(o[0].toString());
						if(cuenta==null){
							recuentoCP.setOpcionCount(0);
						}else{
							recuentoCP.setOpcionCount(cuenta);
						}
						recuentoCP.setOpcion(o[1].toString());
						recuentos.add(recuentoCP);
						
					}
					
				}
				Collection<Object[]> opcionesRec=votacionService.recuentaParaUnaDeterminaPregunta(votacionId, pregunta);
				for(Object[] o:opcionesRec){
				 	RecuentoGeneral recuentoGeneral=recuentoGeneralService.create();
				 	recuentoGeneral.setPregunta(pregunta);
				 	String cuentaV=o[0].toString();
					Integer cuenta=Integer.valueOf(cuentaV);
					if(cuenta==null){
						recuentoGeneral.setOpcionCount(0);
					}else{
						recuentoGeneral.setOpcionCount(cuenta);
					}	
				 	recuentoGeneral.setOpcion(o[1].toString());
					recuentos.add(recuentoGeneral);
				}
			}
			result.setRecuento(recuentos);
			result.setUltimaModififacion(new Date());
			save(result);
			return result;
		}

			
		public String recuento(int votacionId) {
			String result;
			VotacionRec resultado = recuentaVotos(votacionId);
			// Convertir a JSON
			Gson gson = new Gson();
			result = gson.toJson(resultado);
			
			return result;
		}

//		public VotacionRec findByName(String nombre) {
//			VotacionRec result=votacionRecRepository.findByName(nombre);
//			return result;
//		}
}

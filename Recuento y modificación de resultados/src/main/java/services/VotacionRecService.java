package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.google.gson.Gson;

import domain.Opcion;
import domain.Votacion;
import domain.VotacionRec;
import domain.Voto;

import repositories.VotacionRecRepository;

@Service
@Transactional
public class VotacionRecService {
	
	// Managed repository -------------------------------------------------

		@Autowired
		private VotacionRecRepository votacionRecRepository;
		
	// Supporting Service -------------------------------------------------

	// Constructor -------------------------------------------------
	public VotacionRecService() {
		super();
	}
	
	// Simple CRUD methods -------------------------------------------------
		public VotacionRec create() {
			VotacionRec r = new VotacionRec();
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
			votacionRecRepository.save(votacionRec);
			
		}

		public void delete(VotacionRec votacionRecService) {
			Assert.notNull(votacionRecService);
			votacionRecRepository.delete(votacionRecService);
		}

		// Other methods -------------------------------------------------
/*	En el nuevo método le debe entrar una id
 * 	public Collection<Resultado> recuentaVotos(Votacion votacion){
			Collection<Voto> votos=votacion.getVotos();
			Collection<Resultado> res=new ArrayList<Resultado>();
			Map<String,List<Opcion>> rec=new HashMap<String,List<Opcion>>();
			for(Voto v:votos){
				for(Answer a:v.getAns()){
					if(rec.containsKey(a.getQuestion())){
						List<Opcion> opciones=rec.get(a.getQuestion());
						if(opciones==null){
							Opcion o=new Opcion();
							o.setOpcion(a.getAnswer_question());
							o.setVotos(1);
							o.setAns(a);
							List<Opcion>lopciones= new ArrayList<Opcion>();
							lopciones.add(o);
							rec.put(a.getQuestion(), opciones);
						}else{
							boolean contains=false;
							for(Opcion o:opciones){
								if(o.getOpcion().equals(a.getAnswer_question())){
									contains=true;
									Opcion nO=new Opcion();
									nO.setOpcion(o.getOpcion());
									nO.setVotos(o.getVotos()+1);
									nO.setAns(a);
									opciones.remove(o);
									opciones.add(nO);					
								}
							}if(!contains){
								Opcion o=new Opcion();
								o.setOpcion(a.getAnswer_question());
								o.setVotos(1);
								o.setAns(a);
								List<Opcion>lopciones= new ArrayList<Opcion>();
								lopciones.add(o);
								rec.put(a.getQuestion(), opciones);
							}
							
						}
					}
				}
			}
			for(String s:rec.keySet()){
				Resultado r=new Resultado();
				r.setPregunta(s);
				r.setOpciones(rec.get(s));
				res.add(r);
			}
			return res;
		}
		
*/		
		public String recuento(int votacionId) {
			String result;
			VotacionRec votacion = findOne(votacionId);
			//Collection<Resultado> resultado = recuentaVotos(votacion);
			
			// Convertir a JSON
			Gson gson = new Gson();
			result = gson.toJson(votacion);
			
			return result;
		}
}

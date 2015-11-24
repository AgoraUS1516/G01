/* LoginService.java
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Answer;
import domain.Opcion;
import domain.Resultado;
import domain.Votacion;
import domain.Voto;
import repositories.VotacionRepository;

@Service
@Transactional
public class VotacionService {
	
	// Managed repository -----------------------------------------------------

	@Autowired
	VotacionRepository votacionRepository;
	
	
	// CRUD methods -----------------------------------------------------------
	
	public Votacion create(){
		Votacion result=new Votacion();	
		return result;
	}
	public Votacion findOne(int votacionId){
		Votacion result;
		result=votacionRepository.findOne(votacionId);
		return result;
	}
	public Collection<Votacion> findAll(){
		Collection<Votacion> result;
		result=votacionRepository.findAll();
		return result;
	}
	public void save(Votacion votacion){
		votacionRepository.save(votacion);
	}
	public void delete(Votacion votacion){
		votacionRepository.delete(votacion);
	}
	
	// Business methods -------------------------------------------------------
	public Collection<Resultado> recuentaVotos(Votacion votacion){
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
	
	
	public (String) recuento(int votacionId){
		//Llamada a la votación de los métodos cifrados
		//Hacer una votación transformando los votos cifrados en votos normales
		//Meter los votos a una nueva votación
		recuentaVotos(votacion);
		//Convertir a json la votación
		//devolver JSON
		
	}
	
	

}

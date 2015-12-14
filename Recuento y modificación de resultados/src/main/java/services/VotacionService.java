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
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.VotacionRepository;

import com.google.gson.Gson;

import domain.Votacion;
import domain.Voto;

@Service
@Transactional
public class VotacionService {
	
	// Managed repository -----------------------------------------------------

	@Autowired
	private VotacionRepository votacionRepository;
	
	
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
	// Other methods -------------------------------------------------
	public Collection<Object[]> recuentaParaUnaDeterminaPregunta(int votacionId, String pregunta){
		Collection<Object[]> result=votacionRepository.recuentaParaUnaDeterminaPregunta(votacionId, pregunta);
		return result;
		
	}
	public Collection<Object[]> recuentaParaUnaDeterminaPreguntaYCP(int votacionId, String pregunta,int cp){
		Collection<Object[]> result=votacionRepository.recuentaParaUnaDeterminaPreguntaYCP(votacionId, pregunta,cp);
		return result;
		
	}
}

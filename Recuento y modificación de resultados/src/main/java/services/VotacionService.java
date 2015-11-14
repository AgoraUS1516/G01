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

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Votacion;
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
	

}

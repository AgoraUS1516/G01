/* WelcomeController.java
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Votacion;

import services.VotacionRecService;

@Controller
@RequestMapping("/rec/vot")
public class VotacionRecController extends AbstractController {

	@Autowired
	VotacionRecService votacionRecService;
	// Constructors -----------------------------------------------------------
	
	public VotacionRecController() {
		super();
	}
		
	// Index ------------------------------------------------------------------		
	@RequestMapping(value = "/dId")
	public ModelAndView recuentaVotacion(@RequestParam(required=false, defaultValue="1") int vot) {
		ModelAndView result;
		
		// votacionRecService.recuentaVotos(vot);
		//Votacion votacion=votacionService.findOne(vot);
		//VotacionRec votacionRec=votacionService.findByName(vot.name);
		result = new ModelAndView("redirect:rec/vot/vId"+vot);
		return result;
	}
	
	@RequestMapping(value = "/vId")
	public ModelAndView buscaRecuento(@RequestParam int vRec) {
		ModelAndView result;
		String votacionJSON;
		
		votacionJSON=votacionRecService.recuento(vRec);		
		result = new ModelAndView("rec/vot");
		result.addObject("votacionJSON", votacionJSON);
		return result;
	}
}
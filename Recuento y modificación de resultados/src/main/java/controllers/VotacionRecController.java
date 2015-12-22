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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import domain.Votacion;
import domain.VotacionRec;


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
	@RequestMapping(value = "/seeId")
	@ResponseBody
	public String recuentaVotacion( @RequestParam int vot) {
		String result;
		JsonElement json;
		VotacionRec votacionRec=votacionRecService.findOne(vot);
		Gson gson=new Gson();
		json=gson.toJsonTree(votacionRec);
		result=json.toString();
		return result;
	}
	
	@RequestMapping(value = "/vId")
	@ResponseBody
	public String buscaRecuento(@RequestParam Integer vRec) {
//		ModelAndView result;
		String votacionJSON;
		
		votacionJSON=votacionRecService.recuento(vRec).toString();		
//		result = new ModelAndView("rec/vot");
//		result.addObject("votacionJSON", votacionJSON);
		return votacionJSON;
	}
}
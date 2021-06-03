package com.cc.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cc.api.entities.Prospecto;
import com.cc.api.services.ProspectoService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ProspectoController {

	@Autowired
	private ProspectoService pservice;
	
	@RequestMapping(value = "/prospectos", method = RequestMethod.GET, produces = "application/json" )
	public List<Prospecto> getProspectos(){
		return pservice.getProspectos();
	}
	
	@RequestMapping(value = "prospecto/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Prospecto> getProspectoById(@PathVariable int id){
		return pservice.getProspectoById(id);
	}
	
	@RequestMapping(value = "/prospecto/add", method = RequestMethod.POST, produces = "application/json")
	public Prospecto addProspecto(@RequestBody Prospecto prospecto) {
		return pservice.addProspecto(prospecto);
	}
	
	@RequestMapping(value = "/prospecto/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteProspecto(@PathVariable int id) {
		return pservice.deleteProspecto(id);
	}
	
	@RequestMapping(value = "/prospecto/update", method = RequestMethod.PUT , produces = "application/json")
	public Prospecto updateProspecto(@RequestBody Prospecto p) {
		return pservice.updateProspecto(p);
	}
}

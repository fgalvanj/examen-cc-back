package com.cc.api.services;

import java.util.List;
import java.util.Optional;

import com.cc.api.entities.Prospecto;

public interface ProspectoService {

	public List<Prospecto> getProspectos();
	
	public Optional<Prospecto> getProspectoById(int id);
	
	public Prospecto addProspecto(Prospecto newProspecto);
	
	public String deleteProspecto(int id);
	
	public Prospecto updateProspecto(Prospecto p);
	
}

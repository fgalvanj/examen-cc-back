package com.cc.api.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.api.entities.Prospecto;
import com.cc.api.repositories.ProspectoRepository;
import com.cc.api.services.ProspectoService;

@Service
public class ProspectoServicesImpl implements ProspectoService {

	@Autowired
	private ProspectoRepository repo;
	
	@Override
	public List<Prospecto> getProspectos() {
		return this.repo.findAll();
	}

	@Override
	public Optional<Prospecto> getProspectoById(int id) {
		Optional<Prospecto> prospecto = repo.findById(id);
		return prospecto;
	}

	@Override
	public Prospecto addProspecto(Prospecto newProspecto) {
		if(newProspecto != null) {
			return repo.save(newProspecto);
		}
		return new Prospecto();
	}

	@Override
	public String deleteProspecto(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return "El prospecto se elimino correctamente";
		}
		return "Error, prospecto no encontrado.";
	}

	@Override
	public Prospecto updateProspecto(Prospecto p) {
		int id = p.getId();
		if(repo.findById(id).isPresent()) {
			Prospecto newP = new Prospecto();
			newP.setId(id);
			newP.setNombre(p.getNombre());
			newP.setApellidoPaterno(p.getApellidoPaterno());
			newP.setApellidoMaterno(p.getApellidoMaterno());
			newP.setCalle(p.getCalle());
			newP.setNumero(p.getNumero());
			newP.setColonia(p.getColonia());
			newP.setCodigoPostal(p.getCodigoPostal());
			newP.setTelefono(p.getTelefono());
			newP.setRfc(p.getRfc());
			newP.setSituacion(p.getSituacion());
			newP.setObservaciones(p.getObservaciones());
			return repo.save(newP);
		}
		return new Prospecto();
	}
}

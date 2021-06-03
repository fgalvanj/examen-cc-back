package com.cc.api.services;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.cc.api.entities.Archivo;

public interface ArchivoService {
	
	public List<Archivo>getArchivoByIdProspecto(int idProspecto);

	public List<Archivo> getArchivos();
	
	public Optional<Archivo> getArchivoById(int id);
	
	public Archivo addArchivo(Archivo newArchivo);
	
	public String deleteArchivo(int id);
	
	public String updateArchivo(Archivo a);
	
	
    public void init();

    public void save(MultipartFile file);
    
    public Resource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();

    public String deleteFile(String filename);

}

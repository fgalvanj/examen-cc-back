package com.cc.api.servicesImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cc.api.entities.Archivo;
import com.cc.api.repositories.ArchivoRepository;
import com.cc.api.services.ArchivoService;

@Service
public class ArchivoServicesImpl implements ArchivoService {

	 private final Path root = Paths.get("uploads");
	 
	@Autowired
	private ArchivoRepository aRepo; 
	
	@Override
	public List<Archivo> getArchivos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Archivo> getArchivoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Archivo addArchivo(Archivo newArchivo) {
		if(newArchivo != null) {
			return aRepo.save(newArchivo);
		} 
		return new Archivo();
	}

	@Override
	public String deleteArchivo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateArchivo(Archivo a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		try {
            if(!Files.exists(root)) {
            	Files.createDirectory(root);            	
            }
            
        } catch (IOException e) {
            throw new RuntimeException("No se puede inicializar la carpeta uploads");
        }
	}

	@Override
	public void save(MultipartFile file) {
		try {
			int i = 1;
			String name = file.getOriginalFilename();
			Resource r = this.load(name);
			if(r.exists()) { 
				name = i+"_"+file.getOriginalFilename();
				i++;
			}
            Files.copy(file.getInputStream(), 
                       this.root.resolve(name));
        } catch (IOException e) {
            throw new RuntimeException("No se puede guardar el archivo. Error " + e.getMessage());
        }
	}

	@Override
	public Resource load(String filename) {
		 try {
	            Path file = root.resolve(filename);
	            Resource resource = new UrlResource(file.toUri());

	            if(resource.exists() || resource.isReadable()){
	                return resource;
	            }else{
	                throw new RuntimeException("No se puede leer el archivo ");
	            }

	        }catch (MalformedURLException e){
	            throw new RuntimeException("Error: " + e.getMessage());
	        }
	}

	@Override
	public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());		
	}

	@Override
	public Stream<Path> loadAll() {
		 try{
	            return Files.walk(this.root,1).filter(path -> !path.equals(this.root))
	                    .map(this.root::relativize);
	        }catch (RuntimeException | IOException e){
	            throw new RuntimeException("No se pueden cargar los archivos ");
	        }
	}

	@Override
	public String deleteFile(String filename) {
		try {
            Boolean delete = Files.deleteIfExists(this.root.resolve(filename));
                return "Borrado";
        }catch (IOException e){
            e.printStackTrace();
            return "Error Borrando ";
        }
	}

	@Override
	public List<Archivo> getArchivoByIdProspecto(int idProspecto) {
		List<Archivo> archivosList = aRepo.findArchivosByIdProspecto(idProspecto);
		return archivosList;
	}
		
	
}

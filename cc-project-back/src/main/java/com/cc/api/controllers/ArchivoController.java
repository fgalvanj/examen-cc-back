package com.cc.api.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.cc.api.entities.Archivo;
import com.cc.api.entities.FileMessage;
import com.cc.api.services.ArchivoService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ArchivoController {
	@Autowired
	private ArchivoService archivoService;
	
	@PostMapping("/upload")
    public ResponseEntity<?> uploadFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("id") int idProspecto){
		String message = "";
        try{
            List<String> fileNames = new ArrayList<>();

            Arrays.asList(files).stream().forEach(file->{
            	archivoService.save(file);
                fileNames.add(file.getOriginalFilename());
                Resource resource = this.archivoService.load(file.getOriginalFilename());
                
                try {
    				Archivo archivo = new Archivo();
    				archivo.setUrl(resource.getURI().getRawSchemeSpecificPart());
    				archivo.setNombreArchivo(file.getOriginalFilename());
    				archivo.setIdProspecto(idProspecto);
                	archivoService.addArchivo(archivo);
    			} catch (Exception e) {}
            });

            message = "Se subieron los archivos correctamente " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
        }catch (Exception e){
            message = "Fallo al subir los archivos";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<Archivo>> getFiles(){
        List<Archivo> fileInfos = archivoService.loadAll().map(path -> {
          String filename = path.getFileName().toString();
          String url = MvcUriComponentsBuilder.fromMethodName(ArchivoController.class, "getFile",
                  path.getFileName().toString()).build().toString();
          return new Archivo(url, filename);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }


    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename){
        Resource file = archivoService.load(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\""+file.getFilename() + "\"").body(file);
    }

    @GetMapping("/delete/{filename:.+}")
    public ResponseEntity<FileMessage> deleteFile(@PathVariable String filename) {
        String message = "";
        try {
            message = archivoService.deleteFile(filename);
            return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileMessage(message));
        }
    }
    
    @RequestMapping(value = "archivo-prospecto/{idProspecto}", method = RequestMethod.GET, produces = "application/json")
    public List<Archivo>getArchivoByIdProspecto(@PathVariable int idProspecto){
    	return archivoService.getArchivoByIdProspecto(idProspecto);
    }
    
    

}

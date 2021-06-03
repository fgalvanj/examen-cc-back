package com.cc.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cc.api.entities.Archivo;

public interface ArchivoRepository extends JpaRepository<Archivo, Integer> {

	@Query(value = "SELECT * FROM archivos a WHERE a.id_prospecto = :idProspecto", nativeQuery = true)
	List<Archivo> findArchivosByIdProspecto(@Param("idProspecto") int idProspecto);	
}

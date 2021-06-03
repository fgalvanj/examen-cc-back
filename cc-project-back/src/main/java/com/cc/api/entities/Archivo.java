package com.cc.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "archivos")
public class Archivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "url", length = 1000, nullable = true)
	private String url;
	
	@Column(name = "nombre_archivo", length = 1000, nullable = false)
	private String nombreArchivo;
	
	@Column(name = "id_prospecto", nullable = false)
	private int idProspecto;
	
	public Archivo(String url, String nombreArchivo) {
		this.url = url;
		this.nombreArchivo = nombreArchivo;
	}
	
	public Archivo() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public int getIdProspecto() {
		return idProspecto;
	}

	public void setIdProspecto(int idProspecto) {
		this.idProspecto = idProspecto;
	}
	
	
	
	
}

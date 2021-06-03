package com.cc.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prospectos")
public class Prospecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;

	@Column(name = "apellido_paterno", length = 50, nullable = false)
	private String apellidoPaterno;

	@Column(name = "apellido_materno", length = 50, nullable = true)
	private String apellidoMaterno;

	@Column(name = "calle", length = 80, nullable = false)
	private String calle;

	@Column(name = "numero", length = 80, nullable = false)
	private String numero;
	
	@Column(name = "colonia", length = 80, nullable = false)
	private String colonia;
	
	@Column(name = "codigo_postal", length = 5, nullable = false)
	private String codigoPostal;
	
	@Column(name = "telefono", length = 10, nullable = false)
	private String telefono;
	
	@Column(name = "rfc", length = 13, nullable = false)
	private String rfc;
	
	@Column(name = "situacion", length = 30, nullable = false)
	private String situacion;
	
	@Column(name = "observaciones", length = 1000, nullable = true)
	private String observaciones;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}

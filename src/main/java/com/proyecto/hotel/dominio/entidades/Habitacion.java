package com.proyecto.hotel.dominio.entidades;

public class Habitacion {

	private int idhabitacion;
	private String numero;
	private String estado;
	private int piso;
	private int estrellas;
	private int capacidad;
	public Habitacion() {
		super();
	}
	public Habitacion(int idhabitacion, String numero, String estado, int piso, int estrellas, int capacidad) {
		super();
		this.idhabitacion = idhabitacion;
		this.numero = numero;
		this.estado = estado;
		this.piso = piso;
		this.estrellas = estrellas;
		this.capacidad = capacidad;
	}
	public int getIdhabitacion() {
		return idhabitacion;
	}
	public void setIdhabitacion(int idhabitacion) {
		this.idhabitacion = idhabitacion;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public int getEstrellas() {
		return estrellas;
	}
	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	
}

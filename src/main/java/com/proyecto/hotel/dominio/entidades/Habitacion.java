package com.proyecto.hotel.dominio.entidades;

public class Habitacion {

	private int id_habitacion;
	private int numero_habitacion;
	private String estado_habitacion;
	private int piso_habitacion;
	private int estrellas_habitacion;
	private int capacidad_habitacion;
	public Habitacion() {
		super();
	}
	public Habitacion(int id_habitacion, int numero_habitacion, String estado_habitacion, int piso_habitacion,
			int estrellas_habitacion, int capacidad_habitacion) {
		super();
		this.id_habitacion = id_habitacion;
		this.numero_habitacion = numero_habitacion;
		this.estado_habitacion = estado_habitacion;
		this.piso_habitacion = piso_habitacion;
		this.estrellas_habitacion = estrellas_habitacion;
		this.capacidad_habitacion = capacidad_habitacion;
	}
	public int getId_habitacion() {
		return id_habitacion;
	}
	public void setId_habitacion(int id_habitacion) {
		this.id_habitacion = id_habitacion;
	}
	public int getNumero_habitacion() {
		return numero_habitacion;
	}
	public void setNumero_habitacion(int numero_habitacion) {
		this.numero_habitacion = numero_habitacion;
	}
	public String getEstado_habitacion() {
		return estado_habitacion;
	}
	public void setEstado_habitacion(String estado_habitacion) {
		this.estado_habitacion = estado_habitacion;
	}
	public int getPiso_habitacion() {
		return piso_habitacion;
	}
	public void setPiso_habitacion(int piso_habitacion) {
		this.piso_habitacion = piso_habitacion;
	}
	public int getEstrellas_habitacion() {
		return estrellas_habitacion;
	}
	public void setEstrellas_habitacion(int estrellas_habitacion) {
		this.estrellas_habitacion = estrellas_habitacion;
	}
	public int getCapacidad_habitacion() {
		return capacidad_habitacion;
	}
	public void setCapacidad_habitacion(int capacidad_habitacion) {
		this.capacidad_habitacion = capacidad_habitacion;
	}
	
	
	
}

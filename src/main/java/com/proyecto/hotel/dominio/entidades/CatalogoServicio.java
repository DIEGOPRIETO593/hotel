package com.proyecto.hotel.dominio.entidades;

public class CatalogoServicio {

	private int id_servicio;
	private String nombre_servicio;
	private double tarifa;

	public CatalogoServicio() {
		super();
	}

	public CatalogoServicio(int id_servicio, String nombre_servicio, double tarifa) {
		super();
		this.id_servicio = id_servicio;
		this.nombre_servicio = nombre_servicio;
		this.tarifa = tarifa;
	}

	public int getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}

	public String getNombre_servicio() {
		return nombre_servicio;
	}

	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
}
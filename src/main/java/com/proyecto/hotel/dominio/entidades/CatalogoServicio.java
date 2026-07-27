package com.proyecto.hotel.dominio.entidades;

public class CatalogoServicio {

	private int idServicio;
	private String nombreServicio;
	private double tarifa;
	private String descripcion;

	public CatalogoServicio() {
		super();
	}

	public CatalogoServicio(int idServicio, String nombreServicio, double tarifa) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
		this.tarifa = tarifa;
	}

	public CatalogoServicio(int idServicio, String nombreServicio, double tarifa, String descripcion) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
		this.tarifa = tarifa;
		this.descripcion = descripcion;
	}

	public int getidServicio() {
		return idServicio;
	}

	public void setidServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getnombreServicio() {
		return nombreServicio;
	}

	public void setnombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
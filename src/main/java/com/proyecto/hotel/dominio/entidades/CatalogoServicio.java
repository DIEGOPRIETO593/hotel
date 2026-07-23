package com.proyecto.hotel.dominio.entidades;

public class CatalogoServicio {

	private int idServicio;
	private String nombreServicio;
	private double tarifa;

	public CatalogoServicio() {
		super();
	}

	public CatalogoServicio(int idServicio, String nombreServicio, double tarifa) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
		this.tarifa = tarifa;
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
}
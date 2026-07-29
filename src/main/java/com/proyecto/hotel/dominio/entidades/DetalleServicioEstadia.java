package com.proyecto.hotel.dominio.entidades;

import java.util.ArrayList;
import java.util.List;

public class DetalleServicioEstadia {

	private int idDetalle;
	private Estadia estadia; 
	private double total;
	private String estado;
	private List<DetalleServicioItem> items = new ArrayList<>();

	public DetalleServicioEstadia() {
		super();
	}

	public DetalleServicioEstadia(int idDetalle, Estadia estadia, double total, String estado, List<DetalleServicioItem> items) {
		super();
		this.idDetalle = idDetalle;
		this.estadia = estadia;
		this.total = total;
		this.estado = estado;
		this.items = items != null ? items : new ArrayList<>();
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getidDetalle() {
		return idDetalle;
	}

	public void setidDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<DetalleServicioItem> getItems() {
		return items;
	}

	public void setItems(List<DetalleServicioItem> items) {
		this.items = items;
	}
}
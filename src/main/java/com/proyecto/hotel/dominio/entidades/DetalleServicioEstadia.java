package com.proyecto.hotel.dominio.entidades;

public class DetalleServicioEstadia
{

	private int idDetalle;
	private int idEstadia;
	private int idServicio;
	private int cantidad;
	private double subtotal;

	public DetalleServicioEstadia() {
		super();
	}

	public DetalleServicioEstadia(int idDetalle, int idEstadia, int idServicio, int cantidad, double subtotal) {
		super();
		this.idDetalle = idDetalle;
		this.idEstadia = idEstadia;
		this.idServicio = idServicio;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}

	public int getidDetalle() {
		return idDetalle;
	}

	public void setidDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getidEstadia() {
		return idEstadia;
	}

	public void setidEstadia(int idEstadia) {
		this.idEstadia = idEstadia;
	}

	public int getidServicio() {
		return idServicio;
	}

	public void setidServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
package com.proyecto.hotel.dominio.entidades;

public class DetalleServicioEstadia
{

	private int id_detalle;
	private int idEstadia;
	private int id_servicio;
	private int cantidad;
	private double subtotal;

	public DetalleServicioEstadia() {
		super();
	}

	public DetalleServicioEstadia(int id_detalle, int idEstadia, int id_servicio, int cantidad, double subtotal) {
		super();
		this.id_detalle = id_detalle;
		this.idEstadia = idEstadia;
		this.id_servicio = id_servicio;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}

	public int getId_detalle() {
		return id_detalle;
	}

	public void setId_detalle(int id_detalle) {
		this.id_detalle = id_detalle;
	}

	public int getidEstadia() {
		return idEstadia;
	}

	public void setidEstadia(int idEstadia) {
		this.idEstadia = idEstadia;
	}

	public int getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
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
package com.proyecto.hotel.dominio.entidades;

import java.util.Date;

public class Estadia {

	private int id_estadia;
	private int id_huesped;
	private int id_habitacion;
	private Date fecha_ingreso;
	private Date fecha_salida;
	private int cantidad_huespedes;
	private double total_pagar;

	public Estadia() {
		super();
	}

	public Estadia(int id_estadia, int id_huesped, int id_habitacion, Date fecha_ingreso, Date fecha_salida,
			int cantidad_huespedes, double total_pagar) {
		super();
		this.id_estadia = id_estadia;
		this.id_huesped = id_huesped;
		this.id_habitacion = id_habitacion;
		this.fecha_ingreso = fecha_ingreso;
		this.fecha_salida = fecha_salida;
		this.cantidad_huespedes = cantidad_huespedes;
		this.total_pagar = total_pagar;
	}

	public int getId_estadia() {
		return id_estadia;
	}

	public void setId_estadia(int id_estadia) {
		this.id_estadia = id_estadia;
	}

	public int getId_huesped() {
		return id_huesped;
	}

	public void setId_huesped(int id_huesped) {
		this.id_huesped = id_huesped;
	}

	public int getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(int id_habitacion) {
		this.id_habitacion = id_habitacion;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public int getCantidad_huespedes() {
		return cantidad_huespedes;
	}

	public void setCantidad_huespedes(int cantidad_huespedes) {
		this.cantidad_huespedes = cantidad_huespedes;
	}

	public double getTotal_pagar() {
		return total_pagar;
	}

	public void setTotal_pagar(double total_pagar) {
		this.total_pagar = total_pagar;
	}
}
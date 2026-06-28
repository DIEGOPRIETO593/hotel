package com.proyecto.hotel.dominio.entidades;

import java.time.LocalDateTime;

public class Estadia {

	private int idEstadia;
	private int idHuesped;
	private int idHabitacion;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private int cantidadHuespedes;
	private double totalPagar;

	public Estadia() {
		super();
	}

	
	public Estadia(int idEstadia, int idHuesped, int idHabitacion, LocalDateTime fechaIngreso,
			LocalDateTime fechaSalida, int cantidadHuespedes, double totalPagar) {
		super();
		this.idEstadia = idEstadia;
		this.idHuesped = idHuesped;
		this.idHabitacion = idHabitacion;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.cantidadHuespedes = cantidadHuespedes;
		this.totalPagar = totalPagar;
	}


	public int getIdEstadia() {
		return idEstadia;
	}

	public void setIdEstadia(int idEstadia) {
		this.idEstadia = idEstadia;
	}

	public int getIdHuesped() {
		return idHuesped;
	}

	public void setIdHuesped(int idHuesped) {
		this.idHuesped = idHuesped;
	}

	public int getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public int getCantidadHuespedes() {
		return cantidadHuespedes;
	}

	public void setCantidadHuespedes(int cantidadHuespedes) {
		this.cantidadHuespedes = cantidadHuespedes;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}
	
	

}
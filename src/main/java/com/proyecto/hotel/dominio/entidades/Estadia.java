package com.proyecto.hotel.dominio.entidades;

import java.time.LocalDateTime;

public class Estadia {

	private int idEstadia;
	private Huesped huesped; 
    private Habitacion habitacion;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private int cantidadHuespedes;
	private double totalPagar;

	public Estadia() {
		super();
	}

	
	


	public Estadia(int idEstadia, Huesped huesped, Habitacion habitacion, LocalDateTime fechaIngreso,
			LocalDateTime fechaSalida, int cantidadHuespedes, double totalPagar) {
		super();
		this.idEstadia = idEstadia;
		this.huesped = huesped;
		this.habitacion = habitacion;
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

	

	

	public Huesped getHuesped() {
		return huesped;
	}





	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}





	public Habitacion getHabitacion() {
		return habitacion;
	}





	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
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
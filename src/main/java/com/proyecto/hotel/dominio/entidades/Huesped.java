package com.proyecto.hotel.dominio.entidades;

public class Huesped {
	private int idHuesped;
	private String cedula;
	private String nombre;
	private String apellido;
	private String telefono;
	
	
	public Huesped() {
		super();
	}

	public Huesped(int idHuesped, String cedula, String nombre, String apellido, String telefono) {
		super();
		this.idHuesped = idHuesped;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public int getidHuesped() {
		return idHuesped;
	}

	public void setidHuesped(int idHuesped) {
		this.idHuesped = idHuesped;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
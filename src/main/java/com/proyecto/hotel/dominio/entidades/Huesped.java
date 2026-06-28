package com.proyecto.hotel.dominio.entidades;

public class Huesped {
	private int idhuesped;
	private String cedula;
	private String nombre;
	private String apellido;
	private String telefono;	
	
	public Huesped() {
		super();
	}
	public Huesped(int id, String cedula, String nombre, String apellido,
			String telefono) {
		super();
		this.idhuesped = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	public int getId() {
		return idhuesped;
	}
	public void setId(int id) {
		this.idhuesped = id;
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
	public String getTelefono_huesed() {
		return telefono;
	}
	public void setTelefono_huesed(String telefono_huesed) {
		this.telefono = telefono_huesed;
	}
	
	
	

}

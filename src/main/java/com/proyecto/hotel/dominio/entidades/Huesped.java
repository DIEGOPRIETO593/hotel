package com.proyecto.hotel.dominio.entidades;

public class Huesped {
	private int id_huesped;
	private String cedula_huesped;
	private String nombre_huesped;
	private String apellido_huesped;
	private int telefono_huesed;
	
	
	
	public Huesped() {
		super();
	}
	public Huesped(int id_huesped, String cedula_huesped, String nombre_huesped, String apellido_huesped,
			int telefono_huesed) {
		super();
		this.id_huesped = id_huesped;
		this.cedula_huesped = cedula_huesped;
		this.nombre_huesped = nombre_huesped;
		this.apellido_huesped = apellido_huesped;
		this.telefono_huesed = telefono_huesed;
	}
	public int getId_huesped() {
		return id_huesped;
	}
	public void setId_huesped(int id_huesped) {
		this.id_huesped = id_huesped;
	}
	public String getCedula_huesped() {
		return cedula_huesped;
	}
	public void setCedula_huesped(String cedula_huesped) {
		this.cedula_huesped = cedula_huesped;
	}
	public String getNombre_huesped() {
		return nombre_huesped;
	}
	public void setNombre_huesped(String nombre_huesped) {
		this.nombre_huesped = nombre_huesped;
	}
	public String getApellido_huesped() {
		return apellido_huesped;
	}
	public void setApellido_huesped(String apellido_huesped) {
		this.apellido_huesped = apellido_huesped;
	}
	public int getTelefono_huesed() {
		return telefono_huesed;
	}
	public void setTelefono_huesed(int telefono_huesed) {
		this.telefono_huesed = telefono_huesed;
	}
	
	
	

}

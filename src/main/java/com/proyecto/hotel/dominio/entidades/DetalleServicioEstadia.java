package com.proyecto.hotel.dominio.entidades;

public class DetalleServicioEstadia
{

	private int idDetalle;
	private Estadia estadia; 
    private CatalogoServicio catalogo;
	private int cantidad;
	private double total;

	public DetalleServicioEstadia() {
		super();
	}

	

	public DetalleServicioEstadia(int idDetalle, Estadia estadia, CatalogoServicio catalogo, int cantidad,
			double total) {
		super();
		this.idDetalle = idDetalle;
		this.estadia = estadia;
		this.catalogo = catalogo;
		this.cantidad = cantidad;
		this.total = total;
	}



	public int getIdDetalle() {
		return idDetalle;
	}



	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}



	public Estadia getEstadia() {
		return estadia;
	}



	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}



	public CatalogoServicio getCatalogo() {
		return catalogo;
	}



	public void setCatalogo(CatalogoServicio catalogo) {
		this.catalogo = catalogo;
	}



	public int getidDetalle() {
		return idDetalle;
	}

	public void setidDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
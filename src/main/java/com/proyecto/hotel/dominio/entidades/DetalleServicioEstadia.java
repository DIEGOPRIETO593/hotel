package com.proyecto.hotel.dominio.entidades;

public class DetalleServicioEstadia
{

	private int idDetalle;
	private Estadia estadia; 
    private CatalogoServicio catalogo;
	private int cantidad;
	private double subtotal;

	public DetalleServicioEstadia() {
		super();
	}

	

	public DetalleServicioEstadia(int idDetalle, Estadia estadia, CatalogoServicio catalogo, int cantidad,
			double subtotal) {
		super();
		this.idDetalle = idDetalle;
		this.estadia = estadia;
		this.catalogo = catalogo;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
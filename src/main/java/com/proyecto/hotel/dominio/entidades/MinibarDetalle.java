package com.proyecto.hotel.dominio.entidades;

public class MinibarDetalle {
    private int idDetalle;
    private Minibar minibar;
    private Producto producto;
    private int cantidad;

    public MinibarDetalle() {
        super();
    }

    public MinibarDetalle(int idDetalle, Minibar minibar, Producto producto, int cantidad) {
        this.idDetalle = idDetalle;
        this.minibar = minibar;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Minibar getMinibar() {
        return minibar;
    }

    public void setMinibar(Minibar minibar) {
        this.minibar = minibar;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

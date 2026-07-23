package com.proyecto.hotel.dominio.entidades;

public class Minibar {
    private int idMinibar;
    private Habitacion habitacion;
    private Producto producto;
    private int cantidad;

    public Minibar() {
        super();
    }

    public Minibar(int idMinibar, Habitacion habitacion, Producto producto, int cantidad) {
        super();
        this.idMinibar = idMinibar;
        this.habitacion = habitacion;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getIdMinibar() {
        return idMinibar;
    }

    public void setIdMinibar(int idMinibar) {
        this.idMinibar = idMinibar;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
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
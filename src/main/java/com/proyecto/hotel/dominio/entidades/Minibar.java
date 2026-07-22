package com.proyecto.hotel.dominio.entidades;
public class Minibar {
    private int id_minibar;
    private int id_habitacion;
    private int id_producto;
    private int cantidad;
    public Minibar() {}
    public int getId_minibar() { return id_minibar; }
    public void setId_minibar(int id_minibar) { this.id_minibar = id_minibar; }
    public int getId_habitacion() { return id_habitacion; }
    public void setId_habitacion(int id_habitacion) { this.id_habitacion = id_habitacion; }
    public int getId_producto() { return id_producto; }
    public void setId_producto(int id_producto) { this.id_producto = id_producto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}

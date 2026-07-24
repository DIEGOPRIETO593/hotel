package com.proyecto.hotel.dominio.entidades;

public class Producto {
    private int idProducto;
    private String nombre;
    private double precio;
    private Integer cantidad;
    private int stock;

    public Producto() {
        super();
    }

    public Producto(int idProducto, String nombre, double precio, Integer cantidad, int stock) {
        super();
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.stock = stock;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
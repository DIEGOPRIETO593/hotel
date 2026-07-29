package com.proyecto.hotel.dominio.entidades;

public class DetalleServicioItem {
    private int idItem;
    private DetalleServicioEstadia detalleServicio;
    private CatalogoServicio catalogoServicio;
    private int cantidad;
    private double total;

    public DetalleServicioItem() {
    }

    public DetalleServicioItem(int idItem, DetalleServicioEstadia detalleServicio, CatalogoServicio catalogoServicio, int cantidad, double total) {
        this.idItem = idItem;
        this.detalleServicio = detalleServicio;
        this.catalogoServicio = catalogoServicio;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public DetalleServicioEstadia getDetalleServicio() {
        return detalleServicio;
    }

    public void setDetalleServicio(DetalleServicioEstadia detalleServicio) {
        this.detalleServicio = detalleServicio;
    }

    public CatalogoServicio getCatalogoServicio() {
        return catalogoServicio;
    }

    public void setCatalogoServicio(CatalogoServicio catalogoServicio) {
        this.catalogoServicio = catalogoServicio;
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

package com.proyecto.hotel.dominio.entidades;

import java.util.List;

public class Minibar {
    private int idMinibar;
    private Habitacion habitacion;
    private String estado;
    private List<MinibarDetalle> detalles;

    public Minibar() {
        super();
    }

    public Minibar(int idMinibar, Habitacion habitacion, String estado, List<MinibarDetalle> detalles) {
        super();
        this.idMinibar = idMinibar;
        this.habitacion = habitacion;
        this.estado = estado;
        this.detalles = detalles;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<MinibarDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<MinibarDetalle> detalles) {
        this.detalles = detalles;
    }
}
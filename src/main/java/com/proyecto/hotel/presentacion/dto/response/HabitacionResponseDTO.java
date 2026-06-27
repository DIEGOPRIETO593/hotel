package com.proyecto.hotel.presentacion.dto.response;

public class HabitacionResponseDTO {
    
    private Long idHabitacion;
    private String numero;
    private String estado;
    private Integer piso;
    private Integer estrellas;
    private Integer capacidad;

    public Long getIdHabitacion() {
        return idHabitacion;
    }
    public void setIdHabitacion(Long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Integer getPiso() {
        return piso;
    }
    public void setPiso(Integer piso) {
        this.piso = piso;
    }
    public Integer getEstrellas() {
        return estrellas;
    }
    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }
    public Integer getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}

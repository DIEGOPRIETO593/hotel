package com.proyecto.hotel.presentacion.dto.response;

public class DetalleServicioEstadiaResponseDTO {
    
    private Long idDetalle;
    private Long idEstadia;
    private Long idServicio;
    private String nombreServicio;
    private Integer cantidad;
    private Double total;
    private String numeroHabitacion;
    private String nombreHuesped;

    public Long getIdDetalle() {
        return idDetalle;
    }
    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }
    public Long getIdEstadia() {
        return idEstadia;
    }
    public void setIdEstadia(Long idEstadia) {
        this.idEstadia = idEstadia;
    }
    public String getNombreServicio() { return nombreServicio; }
    public void setNombreServicio(String nombreServicio) { this.nombreServicio = nombreServicio; }

    public Long getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }

    public String getNumeroHabitacion() { return numeroHabitacion; }
    public void setNumeroHabitacion(String numeroHabitacion) { this.numeroHabitacion = numeroHabitacion; }
    public String getNombreHuesped() { return nombreHuesped; }
    public void setNombreHuesped(String nombreHuesped) { this.nombreHuesped = nombreHuesped; }
}
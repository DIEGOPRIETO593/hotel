package com.proyecto.hotel.presentacion.dto.response;

public class DetalleServicioEstadiaResponseDTO {
    
    private Long idDetalle;
    private Long idEstadia;
    private Long idServicio;
    private Integer cantidad;
    private Double subtotal;

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
    public Double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}

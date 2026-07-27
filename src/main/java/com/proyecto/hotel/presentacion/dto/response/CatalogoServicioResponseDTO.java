package com.proyecto.hotel.presentacion.dto.response;

public class CatalogoServicioResponseDTO {
    
    private Long idServicio;
    private String nombreServicio;
    private Double tarifa;
    private String descripcion;

    public Long getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }
    public String getNombreServicio() {
        return nombreServicio;
    }
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }
    public Double getTarifa() {
        return tarifa;
    }
    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

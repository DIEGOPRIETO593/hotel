package com.proyecto.hotel.presentacion.dto.response;

import java.time.LocalDateTime;

public class EstadiaResponseDTO {
    
    private Integer idEstadia;
    private Integer idHuesped;
    private Integer idHabitacion;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;
    private Integer cantidadHuespedes;
    private Double totalPagar;

    public Integer getIdEstadia() {
        return idEstadia;
    }
    public void setIdEstadia(Integer idEstadia) {
        this.idEstadia = idEstadia;
    }
    public Integer getIdHuesped() {
        return idHuesped;
    }
    public void setIdHuesped(Integer idHuesped) {
        this.idHuesped = idHuesped;
    }
    public Integer getIdHabitacion() {
        return idHabitacion;
    }
    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public Integer getCantidadHuespedes() {
        return cantidadHuespedes;
    }
    public void setCantidadHuespedes(Integer cantidadHuespedes) {
        this.cantidadHuespedes = cantidadHuespedes;
    }
    public Double getTotalPagar() {
        return totalPagar;
    }
    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }
}

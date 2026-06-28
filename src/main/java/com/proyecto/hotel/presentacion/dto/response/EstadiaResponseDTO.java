package com.proyecto.hotel.presentacion.dto.response;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class EstadiaResponseDTO {
    
    private Long idEstadia;
    private Long idHuesped;
    private Long idHabitacion;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;
    private Integer cantidadHuespedes;
    private Double totalPagar;

    public Long getIdEstadia() {
        return idEstadia;
    }
    public void setIdEstadia(Long idEstadia) {
        this.idEstadia = idEstadia;
    }
    public Long getIdHuesped() {
        return idHuesped;
    }
    public void setIdHuesped(Long idHuesped) {
        this.idHuesped = idHuesped;
    }
    public Long getIdHabitacion() {
        return idHabitacion;
    }
    public void setIdHabitacion(Long idHabitacion) {
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

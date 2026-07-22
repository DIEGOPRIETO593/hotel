package com.proyecto.hotel.presentacion.dto.response;

import java.sql.Timestamp;

public class EstadiaResponseDTO {
    
    private Long idEstadia;
    private Long idHuesped;
    private Long idHabitacion;
    private Timestamp fechaIngreso;
    private Timestamp fechaSalida;
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
    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public Timestamp getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(Timestamp fechaSalida) {
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

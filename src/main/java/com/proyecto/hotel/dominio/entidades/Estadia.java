package com.proyecto.hotel.dominio.entidades;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Estadia {
    private int idEstadia;
    private int idHuesped;
    private int idHabitacion;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;
    private int cantidadHuespedes;
    private double totalPagar;
}
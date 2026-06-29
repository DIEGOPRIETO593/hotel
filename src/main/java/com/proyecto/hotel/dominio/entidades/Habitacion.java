package com.proyecto.hotel.dominio.entidades;

import lombok.Data;

@Data
public class Habitacion {
    private int idHabitacion;
    private String numero;
    private String estado;
    private int piso;
    private int estrellas;
    private int capacidad;
}

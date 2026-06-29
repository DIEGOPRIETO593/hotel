package com.proyecto.hotel.dominio.entidades;

import lombok.Data;

@Data
public class Huesped {
    private int idHuesped;
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
}

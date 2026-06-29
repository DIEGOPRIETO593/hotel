package com.proyecto.hotel.dominio.entidades;

import lombok.Data;

@Data
public class CatalogoServicio {
    private int idServicio;
    private String nombreServicio;
    private double tarifa;
}
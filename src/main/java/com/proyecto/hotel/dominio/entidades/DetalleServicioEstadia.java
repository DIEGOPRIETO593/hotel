package com.proyecto.hotel.dominio.entidades;

import lombok.Data;

@Data
public class DetalleServicioEstadia {
    private int idDetalle;
    private int idEstadia;
    private int idServicio;
    private int cantidad;
    private double subtotal;
}
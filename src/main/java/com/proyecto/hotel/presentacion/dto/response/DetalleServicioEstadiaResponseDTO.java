package com.proyecto.hotel.presentacion.dto.response;

import lombok.Data;

@Data
public class DetalleServicioEstadiaResponseDTO {
    
    private int idDetalle;
    private int idEstadia;
    private int idServicio;
    private int cantidad;
    private double subtotal;
}

package com.proyecto.hotel.presentacion.dto.response;

import lombok.Data;

@Data
public class CatalogoServicioResponseDTO {
    
    private int idServicio;
    private String nombreServicio;
    private double tarifa;
}

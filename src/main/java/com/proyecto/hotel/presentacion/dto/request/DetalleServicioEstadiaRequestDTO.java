package com.proyecto.hotel.presentacion.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class DetalleServicioEstadiaRequestDTO {
    private int idDetalle;
    
    @NotNull
    private Integer idEstadia;

    private String estado;
    
    private List<Integer> idServicios;
    
    private List<Integer> cantidades;
    
    private List<Double> totales;
}
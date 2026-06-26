package com.proyecto.hotel.presentacion.dto.request;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class DetalleServicioEstadiaRequestDTO {
    private int idDetalle;
    
    @NotNull
    private int idEstadia;
    
    @NotNull
    private int idServicio;
    
    @NotNull
    private int cantidad;
    
    @NotNull
    private BigDecimal subtotal;
}
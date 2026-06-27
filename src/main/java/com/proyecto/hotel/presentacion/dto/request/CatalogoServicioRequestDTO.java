package com.proyecto.hotel.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CatalogoServicioRequestDTO {
    private int idServicio;
    
    @NotBlank
    private String nombreServicio;
    
    @NotNull
    private BigDecimal tarifa;
}
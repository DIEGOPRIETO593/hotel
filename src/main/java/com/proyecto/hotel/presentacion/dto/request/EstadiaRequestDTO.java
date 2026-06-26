package com.proyecto.hotel.presentacion.dto.request;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class EstadiaRequestDTO {
    private int idEstadia;
    
    @NotNull
    private int idHuesped;
    
    @NotNull
    private int idHabitacion;
    
    @NotNull
    private LocalDateTime fechaIngreso;
    
    @NotNull
    private LocalDateTime fechaSalida;
    
    @NotNull
    private int cantidadHuespedes;
    
    @NotNull
    private BigDecimal totalPagar;
}
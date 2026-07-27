package com.proyecto.hotel.presentacion.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
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
    public LocalDateTime fechaIngreso;
    
    @NotNull
    public LocalDateTime fechaSalida;
    
    @NotNull
    private int cantidadHuespedes;
    
    @NotNull
    private BigDecimal totalPagar;
    
    private String estado;
}
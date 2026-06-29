package com.proyecto.hotel.presentacion.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class EstadiaResponseDTO {
    
    private int idEstadia;
    private int idHuesped;
    private int idHabitacion;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;
    private int cantidadHuespedes;
    private BigDecimal totalPagar;
}

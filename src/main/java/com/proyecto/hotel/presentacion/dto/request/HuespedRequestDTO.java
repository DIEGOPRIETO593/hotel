package com.proyecto.hotel.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HuespedRequestDTO {
    private int idHuesped;
    
    @NotBlank
    private String cedula;
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String apellido;
    
    @NotBlank
    private String telefono;
}
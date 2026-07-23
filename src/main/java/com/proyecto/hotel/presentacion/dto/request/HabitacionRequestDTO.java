package com.proyecto.hotel.presentacion.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HabitacionRequestDTO {
    private int idHabitacion;
    
    @NotBlank
    private String numero;
    
    @NotBlank
    private String estado;
    
    @NotNull
    private int piso;
    
    @NotNull
    private int estrellas;
    
    @NotNull
    private int capacidad;
}
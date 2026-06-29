package com.proyecto.hotel.presentacion.dto.response;

import lombok.Data;

@Data
public class HabitacionResponseDTO {
    
    private int idHabitacion;
    private String numero;
    private String estado;
    private int piso;
    private int estrellas;
    private int capacidad;
}

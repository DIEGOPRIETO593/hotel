package com.proyecto.hotel.presentacion.dto.response;

import lombok.Data;

@Data
public class HuespedResponseDTO {
    
    private int idHuesped;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
}

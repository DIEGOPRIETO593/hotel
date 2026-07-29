package com.proyecto.hotel.presentacion.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class DetalleServicioEstadiaResponseDTO {
    
    private Integer idDetalle;
    private String numeroHabitacion;
    private String nombreHuesped;
    private Integer idEstadia;
    private String estado;
    private Double total;
    private List<DetalleServicioItemResponseDTO> items;

}
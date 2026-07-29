package com.proyecto.hotel.presentacion.dto.response;

import lombok.Data;

@Data
public class DetalleServicioItemResponseDTO {
    private Integer idItem;
    private Integer idServicio;
    private String nombreServicio;
    private Integer cantidad;
    private Double total;
}

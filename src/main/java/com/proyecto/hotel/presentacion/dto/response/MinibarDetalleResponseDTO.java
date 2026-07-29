package com.proyecto.hotel.presentacion.dto.response;

import lombok.Data;

@Data
public class MinibarDetalleResponseDTO {
    private Long idDetalle;
    private Long idProducto;
    private String nombreProducto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
}

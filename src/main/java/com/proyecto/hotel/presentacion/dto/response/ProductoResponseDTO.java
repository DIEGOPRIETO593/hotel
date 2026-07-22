package com.proyecto.hotel.presentacion.dto.response;
import lombok.Data;
@Data
public class ProductoResponseDTO {
    private Long idProducto;
    private String nombre;
    private Double precio;
    private Integer stock;
}

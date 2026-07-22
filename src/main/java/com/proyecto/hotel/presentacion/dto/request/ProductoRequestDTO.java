package com.proyecto.hotel.presentacion.dto.request;
import lombok.Data;
@Data
public class ProductoRequestDTO {
    private int idProducto;
    private String nombre;
    private double precio;
    private int stock;
}

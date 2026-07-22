package com.proyecto.hotel.presentacion.dto.request;
import lombok.Data;
@Data
public class MinibarRequestDTO {
    private int idMinibar;
    private int idHabitacion;
    private int idProducto;
    private int cantidad;
}

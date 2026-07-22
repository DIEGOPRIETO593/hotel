package com.proyecto.hotel.presentacion.dto.response;
import lombok.Data;
@Data
public class MinibarResponseDTO {
    private Long idMinibar;
    private Long idHabitacion;
    private Long idProducto;
    private Integer cantidad;
}

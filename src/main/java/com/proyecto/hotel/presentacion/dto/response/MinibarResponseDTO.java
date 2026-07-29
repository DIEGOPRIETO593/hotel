package com.proyecto.hotel.presentacion.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class MinibarResponseDTO {

    private Long idMinibar;
    private Long idHabitacion;
    private String numeroHabitacion;
    private String estado;
    private Double total;
    private List<MinibarDetalleResponseDTO> detalles;

}

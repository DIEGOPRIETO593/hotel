package com.proyecto.hotel.presentacion.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MinibarRequestDTO {

    private int idMinibar;

    @NotNull(message = "El ID de la habitación es obligatorio")
    private int idHabitacion;

    @NotNull(message = "El ID del producto es obligatorio")
    private int idProducto;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private int cantidad;

    private String estado;
}
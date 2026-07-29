package com.proyecto.hotel.presentacion.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class MinibarRequestDTO {

    private int idMinibar;

    @NotNull(message = "El ID de la habitación es obligatorio")
    private int idHabitacion;

    @NotNull(message = "Los productos son obligatorios")
    private List<Integer> idProductos;

    @NotNull(message = "Las cantidades son obligatorias")
    private List<Integer> cantidades;

    private String estado;
}
package com.proyecto.hotel.aplicacion.casosuso.entrada;

import java.util.List;
import com.proyecto.hotel.dominio.entidades.Habitacion;

public interface IHabitacionUseCase {
    Habitacion guardar(Habitacion nuevaHabitacion);
    Habitacion buscarPorId(int idHabitacion);
    List<Habitacion> listarTodos();
    void eliminar(int idHabitacion);
}
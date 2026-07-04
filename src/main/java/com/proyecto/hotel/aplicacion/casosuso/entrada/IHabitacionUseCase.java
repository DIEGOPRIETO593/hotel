package com.proyecto.hotel.aplicacion.casosuso.entrada;

import java.util.List;
import com.proyecto.hotel.dominio.entidades.Habitacion;

public interface IHabitacionUseCase {
    Habitacion guardar(Habitacion nuevaHabitacion);
    Habitacion buscarPorId(int idHabitacion);
    List<Habitacion> buscarPorEstado(String estado); 
	List<Habitacion> buscarCapacidad(int capacidad); 
    List<Habitacion> listarTodos();
    void eliminar(int idHabitacion);
}
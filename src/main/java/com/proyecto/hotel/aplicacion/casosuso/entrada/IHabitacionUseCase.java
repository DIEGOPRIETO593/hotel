package com.proyecto.hotel.aplicacion.casosuso.entrada;

import java.util.List;
import com.proyecto.hotel.dominio.entidades.Habitacion;
import com.proyecto.hotel.dominio.entidades.Huesped;

public interface IHabitacionUseCase {
    Habitacion guardar(Habitacion nuevaHabitacion);
    Habitacion actualizar(int idHabitacion, Habitacion datosActualizados);
    Habitacion buscarPorId(int idHabitacion);
    List<Habitacion> buscarPorEstado(String estado); 
	List<Habitacion> buscarCapacidad(int capacidad); 
    List<Habitacion> listarTodos();
    void eliminar(int idHabitacion);
}

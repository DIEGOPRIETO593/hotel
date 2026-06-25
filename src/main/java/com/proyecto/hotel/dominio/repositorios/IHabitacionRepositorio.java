package com.proyecto.hotel.dominio.repositorios;

import java.util.List;
import java.util.Optional;
import com.proyecto.hotel.dominio.entidades.Habitacion;

public interface IHabitacionRepositorio {

	Habitacion guardar(Habitacion nuevaHabitacion);
	Optional<Habitacion> buscarPorId(int idHabitacion);
	List<Habitacion> listarTodos();
	List<Habitacion> buscarPorEstado(String estado); 
	void eliminar(int idHabitacion);
}
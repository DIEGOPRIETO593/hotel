package com.proyecto.hotel.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;

public interface IDetalleServicioEstadiaRepositorio {

	DetalleServicioEstadia guardar(DetalleServicioEstadia nuevoDetalle);
	Optional<DetalleServicioEstadia> buscarPorId(int idDetalle);
	List<DetalleServicioEstadia> listarTodos();
	void eliminar(int idDetalle);
}
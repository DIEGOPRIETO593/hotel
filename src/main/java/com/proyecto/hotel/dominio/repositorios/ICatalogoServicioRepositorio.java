package com.proyecto.hotel.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.proyecto.hotel.dominio.entidades.CatalogoServicio;

public interface ICatalogoServicioRepositorio {

	CatalogoServicio guardar(CatalogoServicio nuevoServicio);
	Optional<CatalogoServicio> buscarPorId(int idServicio);
	List<CatalogoServicio> listarTodos();
	void eliminar(int idServicio);
}
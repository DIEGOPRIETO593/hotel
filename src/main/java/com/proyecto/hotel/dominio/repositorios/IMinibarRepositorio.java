package com.proyecto.hotel.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.proyecto.hotel.dominio.entidades.Minibar;

public interface IMinibarRepositorio {

	Minibar guardar(Minibar nuevoMinibar);
	Optional<Minibar> buscarPorId(int idMinibar);
	Optional<Minibar> buscarPorCedula(String cedula); 
	List<Minibar> listarTodos();
	void eliminar(int idMinibar);
}
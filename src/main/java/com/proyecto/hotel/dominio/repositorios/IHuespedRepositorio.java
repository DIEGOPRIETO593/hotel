package com.proyecto.hotel.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.proyecto.hotel.dominio.entidades.Huesped;

public interface IHuespedRepositorio {

	Huesped guardar(Huesped nuevoHuesped);
	Optional<Huesped> buscarPorId(int idHuesped);
	Optional<Huesped> buscarPorCedula(String cedula); 
	List<Huesped> listarTodos();
	void eliminar(int idHuesped);
}
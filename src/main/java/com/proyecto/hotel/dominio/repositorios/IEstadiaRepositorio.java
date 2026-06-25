package com.proyecto.hotel.dominio.repositorios;

import java.util.List;
import java.util.Optional;
import com.proyecto.hotel.dominio.entidades.Estadia;

public interface IEstadiaRepositorio {

	Estadia guardar(Estadia nuevaEstadia);
	Optional<Estadia> buscarPorId(int idEstadia);
	List<Estadia> listarTodos();
	List<Estadia> buscarPorHuesped(int idHuesped); 
	void eliminar(int idEstadia);
}
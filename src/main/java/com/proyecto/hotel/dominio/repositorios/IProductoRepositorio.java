package com.proyecto.hotel.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.proyecto.hotel.dominio.entidades.Producto;

public interface IProductoRepositorio {

	Producto guardar(Producto nuevoProducto);
	Optional<Producto> buscarPorId(int idProducto);
	List<Producto> listarTodos();
	void eliminar(int idProducto);
}
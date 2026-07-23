package com.proyecto.hotel.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.proyecto.hotel.dominio.entidades.Producto;
import com.proyecto.hotel.dominio.repositorios.IProductoRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.jpa.ProductoEntity;
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.proyecto.hotel.infraestructura.repositorios.IProductoJpaRepositorio;

public class ProductoRepositorioImpl implements IProductoRepositorio {
	
	private final IProductoJpaRepositorio jpaRepositorio;
	private final IProductoJpaMapper entityMapper;
	
	public ProductoRepositorioImpl(IProductoJpaRepositorio jpaRepositorio, IProductoJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Producto guardar(Producto nuevoProducto) {
		ProductoEntity entity = entityMapper.toEntity(nuevoProducto);
		ProductoEntity guardado = jpaRepositorio.save(entity);		
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Producto> buscarPorId(int idProducto) {
		return jpaRepositorio.findById(idProducto).map(entityMapper::toDomain);
	}

	@Override
	public List<Producto> listarTodos() {
		return jpaRepositorio.findAll().stream()
				.map(entityMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public void eliminar(int idProducto) {
		jpaRepositorio.deleteById(idProducto);
	}

	
}
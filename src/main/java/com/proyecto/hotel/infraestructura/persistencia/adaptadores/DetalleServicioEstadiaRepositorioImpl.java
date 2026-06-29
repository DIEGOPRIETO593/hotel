package com.proyecto.hotel.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;
import com.proyecto.hotel.dominio.repositorios.IDetalleServicioEstadiaRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.jpa.DetalleServicioEntity; 
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.IDetalleServicioEstadiaJpaMapper;
import com.proyecto.hotel.infraestructura.repositorios.IDetalleServicioJpaRepositorio;

public class DetalleServicioEstadiaRepositorioImpl implements IDetalleServicioEstadiaRepositorio {
	
	private final IDetalleServicioJpaRepositorio jpaRepositorio;
	private final IDetalleServicioEstadiaJpaMapper entityMapper;
	
	public DetalleServicioEstadiaRepositorioImpl(IDetalleServicioJpaRepositorio jpaRepositorio,
			IDetalleServicioEstadiaJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public DetalleServicioEstadia guardar(DetalleServicioEstadia nuevoDetalle) {
		DetalleServicioEntity entity = entityMapper.toEntity(nuevoDetalle);
		DetalleServicioEntity guardado = jpaRepositorio.save(entity);		
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<DetalleServicioEstadia> buscarPorId(int idDetalle) {
		return jpaRepositorio.findById(idDetalle).map(entityMapper::toDomain);
	}

	@Override
	public List<DetalleServicioEstadia> listarTodos() {
		return jpaRepositorio.findAll().stream()
				.map(entityMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public void eliminar(int idDetalle) {
		jpaRepositorio.deleteById(idDetalle);
	}
}
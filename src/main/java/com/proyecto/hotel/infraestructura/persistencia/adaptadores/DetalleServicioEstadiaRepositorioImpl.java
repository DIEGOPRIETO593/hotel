package com.proyecto.hotel.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;
import com.proyecto.hotel.dominio.repositorios.IDetalleServicioEstadiaRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.jpa.DetalleServicoEntity;
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.IDetalleServicioEstadiaJpaMapper;
import com.proyecto.hotel.infraestructura.repositorios.IDetalleServicioJpaRepositorio;

public class DetalleServicioEstadiaRepositorioImpl implements IDetalleServicioEstadiaRepositorio {
	
	private final IDetalleServicioJpaRepositorio jpaRepositorio;
	private final IDetalleServicioEstadiaJpaMapper entityMapper;
	
	public DetalleServicioEstadiaRepositorioImpl(IDetalleServicioJpaRepositorio jpaRepositorio, IDetalleServicioEstadiaJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public DetalleServicioEstadia guardar(DetalleServicioEstadia nuevoDetalle) {
		DetalleServicoEntity entity = entityMapper.toEntity(nuevoDetalle);
		DetalleServicoEntity guardado = jpaRepositorio.save(entity);		
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<DetalleServicioEstadia> buscarPorId(int idDetalle) {
		return jpaRepositorio.findById(idDetalle).map(entityMapper::toDomain);
	}

	@Override
	public void eliminar(int idDetalle) {
		jpaRepositorio.deleteById(idDetalle);
	}

	@Override
	public List<DetalleServicioEstadia> listarPorEstadia(int idEstadia) {
		List<DetalleServicoEntity> entidades = jpaRepositorio.findByIdEstadia(idEstadia);
		return entidades.stream()
				.map(entityMapper::toDomain)
				.collect(Collectors.toList());
	}
}
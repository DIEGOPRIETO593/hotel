package com.proyecto.hotel.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.proyecto.hotel.dominio.entidades.Estadia;
import com.proyecto.hotel.dominio.repositorios.IEstadiaRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.jpa.EstadiaEntity;
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.IEstadiaJpaMapper;
import com.proyecto.hotel.infraestructura.repositorios.IEstadiaJpaRepositorio;

public class EstadiaRepositorioImpl implements IEstadiaRepositorio {
	
	private final IEstadiaJpaRepositorio jpaRepositorio;
	private final IEstadiaJpaMapper entityMapper;
	
	public EstadiaRepositorioImpl(IEstadiaJpaRepositorio jpaRepositorio, IEstadiaJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Estadia guardar(Estadia nuevaEstadia) {
		EstadiaEntity entity = entityMapper.toEntity(nuevaEstadia);
		EstadiaEntity guardado = jpaRepositorio.save(entity);		
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Estadia> buscarPorId(int idEstadia) {
		Optional<EstadiaEntity> entity = jpaRepositorio.findById(idEstadia);
		return entity.map(entityMapper::toDomain);
	}

	@Override
	public List<Estadia> listarTodos() {
		List<EstadiaEntity> entidades = jpaRepositorio.findAll();
		return entidades.stream()
				.map(entityMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public void eliminar(int idEstadia) {
		jpaRepositorio.deleteById(idEstadia);
	}

	@Override
	public List<Estadia> buscarPorHuesped(int idHuesped) {
		// TODO Auto-generated method stub
		return null;
	}
}
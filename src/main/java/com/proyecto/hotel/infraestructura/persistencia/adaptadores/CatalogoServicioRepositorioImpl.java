package com.proyecto.hotel.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.proyecto.hotel.dominio.entidades.CatalogoServicio;
import com.proyecto.hotel.dominio.repositorios.ICatalogoServicioRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.jpa.CatalogoEntity;
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.ICatalogoServicioJpaMapper;
import com.proyecto.hotel.infraestructura.repositorios.ICatalogoJpaRepositorio;

public class CatalogoServicioRepositorioImpl implements ICatalogoServicioRepositorio {
	
	private final ICatalogoJpaRepositorio jpaRepositorio;
	private final ICatalogoServicioJpaMapper entityMapper;
	
	public CatalogoServicioRepositorioImpl(ICatalogoJpaRepositorio jpaRepositorio, ICatalogoServicioJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public CatalogoServicio guardar(CatalogoServicio nuevoServicio) {
		CatalogoEntity entity = entityMapper.toEntity(nuevoServicio);
		// CORRECCIÓN: Spring Data usa .save()
		CatalogoEntity guardado = jpaRepositorio.save(entity);		
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<CatalogoServicio> buscarPorId(int idServicio) {
		// CORRECCIÓN: Spring Data usa .findById()
		return jpaRepositorio.findById(idServicio).map(entityMapper::toDomain);
	}

	@Override
	public List<CatalogoServicio> listarTodos() {
		// CORRECCIÓN: Spring Data usa .findAll()
		return jpaRepositorio.findAll().stream()
				.map(entityMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public void eliminar(int idServicio) {
		// CORRECCIÓN: Spring Data usa .deleteById()
		jpaRepositorio.deleteById(idServicio);
	}
}
package com.proyecto.hotel.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.proyecto.hotel.dominio.entidades.Huesped;
import com.proyecto.hotel.dominio.repositorios.IHuespedRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.jpa.HuespedEntity;
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.IHuespedJpaMapper;
import com.proyecto.hotel.infraestructura.repositorios.IHuespedJpaRepositorio;

public class HuespedRepositorioImpl implements IHuespedRepositorio {
	
	private final IHuespedJpaRepositorio jpaRepositorio;
	private final IHuespedJpaMapper entityMapper;
	
	public HuespedRepositorioImpl(IHuespedJpaRepositorio jpaRepositorio, IHuespedJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Huesped guardar(Huesped nuevoHuesped) {
		HuespedEntity entity = entityMapper.toEntity(nuevoHuesped);
		HuespedEntity guardado = jpaRepositorio.save(entity);		
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Huesped> buscarPorId(int idHuesped) {
		return jpaRepositorio.findById(idHuesped).map(entityMapper::toDomain);
	}

	@Override
	public List<Huesped> listarTodos() {
		return jpaRepositorio.findAll().stream()
				.map(entityMapper::toDomain)
				.collect(Collectors.toList());
	}

	@Override
	public void eliminar(int idHuesped) {
		jpaRepositorio.deleteById(idHuesped);
	}

	@Override
	public Optional<Huesped> buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}
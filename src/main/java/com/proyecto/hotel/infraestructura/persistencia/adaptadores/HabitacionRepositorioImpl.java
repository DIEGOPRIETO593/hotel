package com.proyecto.hotel.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.proyecto.hotel.dominio.entidades.Habitacion;
import com.proyecto.hotel.dominio.repositorios.IHabitacionRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.jpa.HabitacionEntity;
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.IHabitacionJpaMapper;
import com.proyecto.hotel.infraestructura.repositorios.IHabitacionJpaRepositorio;

public class HabitacionRepositorioImpl implements IHabitacionRepositorio {

	private final IHabitacionJpaRepositorio jpaRepositorio;
	private final IHabitacionJpaMapper entityMapper;

	public HabitacionRepositorioImpl(IHabitacionJpaRepositorio jpaRepositorio, IHabitacionJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Habitacion guardar(Habitacion nuevaHabitacion) {
		HabitacionEntity entity = entityMapper.toEntity(nuevaHabitacion);
		HabitacionEntity guardada = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardada);
	}

	@Override
	public Optional<Habitacion> buscarPorId(int idHabitacion) {
		return jpaRepositorio.findById(idHabitacion).map(entityMapper::toDomain);
	}

	@Override
	public List<Habitacion> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).collect(Collectors.toList());
	}

	@Override
	public void eliminar(int idHabitacion) {
		jpaRepositorio.deleteById(idHabitacion);
	}

	@Override
	public List<Habitacion> buscarPorEstado(String estado) {
		// TODO Auto-generated method stub
		return null;
	}
}
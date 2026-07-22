package com.proyecto.hotel.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.hotel.infraestructura.persistencia.jpa.HabitacionEntity;

public interface IHabitacionJpaRepositorio extends JpaRepository<HabitacionEntity, Integer>{
	
	List<HabitacionEntity> findByEstado(String estado);
	List<HabitacionEntity> findByCapacidad(int capacidad);

}
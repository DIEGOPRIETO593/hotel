package com.proyecto.hotel.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.hotel.infraestructura.persistencia.jpa.HabitacionEntity;

public interface IHabitacionJpaRepositorio extends JpaRepository<HabitacionEntity, Integer>{

}

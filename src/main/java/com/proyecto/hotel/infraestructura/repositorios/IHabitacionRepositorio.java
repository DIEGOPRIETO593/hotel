package com.proyecto.hotel.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.hotel.infraestructura.persistencia.jpa.habitacionEntity;

public interface IHabitacionRepositorio extends JpaRepository<habitacionEntity, Integer>{

}

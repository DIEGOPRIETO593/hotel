package com.proyecto.hotel.infraestructura.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.hotel.dominio.entidades.Huesped;
import com.proyecto.hotel.infraestructura.persistencia.jpa.HuespedEntity;

public interface IHuespedJpaRepositorio extends JpaRepository<HuespedEntity, Integer>{

	Optional<HuespedEntity> findByCedula(String cedula);

}

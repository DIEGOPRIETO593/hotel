package com.proyecto.hotel.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.hotel.infraestructura.persistencia.jpa.EstadiaEntity;

public interface IEstadiaJpaRepositorio extends JpaRepository<EstadiaEntity, Integer>{

}

package com.proyecto.hotel.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.hotel.infraestructura.persistencia.jpa.huespedEntity;

public interface IHuespedRepositorio extends JpaRepository<huespedEntity, Integer>{

}

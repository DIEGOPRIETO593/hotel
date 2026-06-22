package com.proyecto.hotel.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.hotel.infraestructura.persistencia.jpa.estadiaEntity;

public interface IEstadiaRepositorio extends JpaRepository<estadiaEntity, Integer>{

}

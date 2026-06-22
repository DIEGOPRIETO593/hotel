package com.proyecto.hotel.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.hotel.infraestructura.persistencia.jpa.catalogoEntity;



public interface ICatalogoRepositorio extends JpaRepository<catalogoEntity, Integer>{

}

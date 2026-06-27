package com.proyecto.hotel.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.hotel.infraestructura.persistencia.jpa.CatalogoEntity;

public interface ICatalogoJpaRepositorio extends JpaRepository<CatalogoEntity, Integer> {
}
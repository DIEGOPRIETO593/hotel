package com.proyecto.hotel.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.hotel.infraestructura.persistencia.jpa.detalleServicoEntity;

public interface IDetalleServicioRepositorio extends JpaRepository<detalleServicoEntity, Integer>{

}

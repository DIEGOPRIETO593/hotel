package com.proyecto.hotel.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.hotel.dominio.entidades.Minibar;
import com.proyecto.hotel.infraestructura.persistencia.jpa.MinibarEntity;

public interface IMinibarJpaRepositorio extends JpaRepository<MinibarEntity, Integer>{

	//List<MinibarEntity> findByHabitacionIdhabitacion(int idhabitacion);

    
    List<MinibarEntity> findByProductoIdProducto(int idProducto);
	

}

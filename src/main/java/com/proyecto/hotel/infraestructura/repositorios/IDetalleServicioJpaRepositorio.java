package com.proyecto.hotel.infraestructura.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.proyecto.hotel.infraestructura.persistencia.jpa.DetalleServicioEntity;

public interface IDetalleServicioJpaRepositorio extends JpaRepository<DetalleServicioEntity, Integer> {
    
    @Query("SELECT d FROM DetalleServicioEntity d WHERE d.estadia.idEstadia = :idEstadia")
    List<DetalleServicioEntity> findByIdEstadia(@Param("idEstadia") int idEstadia);
}
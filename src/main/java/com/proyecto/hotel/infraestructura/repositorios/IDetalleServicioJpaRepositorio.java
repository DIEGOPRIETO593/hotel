package com.proyecto.hotel.infraestructura.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.proyecto.hotel.infraestructura.persistencia.jpa.DetalleServicoEntity;

public interface IDetalleServicioJpaRepositorio extends JpaRepository<DetalleServicoEntity, Integer> {
    
    
    @Query("SELECT d FROM DetalleServicoEntity d WHERE d.estadia.id_estadia = :idEstadia")
    List<DetalleServicoEntity> findByIdEstadia(@Param("idEstadia") int idEstadia);
}
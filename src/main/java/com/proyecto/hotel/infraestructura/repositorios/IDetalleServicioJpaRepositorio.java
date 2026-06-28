package com.proyecto.hotel.infraestructura.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.hotel.infraestructura.persistencia.jpa.DetalleServicoEntity;

public interface IDetalleServicioJpaRepositorio extends JpaRepository<DetalleServicoEntity, Integer> {
    
    // Spring Data genera automáticamente la consulta navegando a estadia -> idEstadia
    List<DetalleServicoEntity> findByEstadia_IdEstadia(int idEstadia);
}
package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;
import com.proyecto.hotel.infraestructura.persistencia.jpa.DetalleServicoEntity; // <-- Nota que aquí dice "Servico" (sin la 'i')
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring", uses = { IHuespedJpaMapper.class, IHabitacionJpaMapper.class })
public interface IDetalleServicioEstadiaJpaMapper {

	@Mapping(target = "catalogoServicio", source = "catalogo") 
    DetalleServicoEntity toEntity(DetalleServicioEstadia domain);

    
    @Mapping(target = "catalogo", source = "catalogoServicio")
    DetalleServicioEstadia toDomain(DetalleServicoEntity entity);
}
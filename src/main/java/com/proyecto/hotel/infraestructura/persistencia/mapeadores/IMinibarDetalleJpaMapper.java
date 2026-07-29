package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.proyecto.hotel.dominio.entidades.MinibarDetalle;
import com.proyecto.hotel.infraestructura.persistencia.jpa.MinibarDetalleEntity;

@Mapper(componentModel = "spring")
public interface IMinibarDetalleJpaMapper {
    @Mapping(target = "minibar", ignore = true)
    MinibarDetalle toDomain(MinibarDetalleEntity entity);
    
    @Mapping(target = "minibar", ignore = true)
    MinibarDetalleEntity toEntity(MinibarDetalle domain);
}

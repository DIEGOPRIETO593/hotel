package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;
import com.proyecto.hotel.dominio.entidades.DetalleServicioItem;
import com.proyecto.hotel.infraestructura.persistencia.jpa.DetalleServicoEntity;
import com.proyecto.hotel.infraestructura.persistencia.jpa.DetalleServicioItemEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = { IEstadiaJpaMapper.class, ICatalogoServicioJpaMapper.class, IHuespedJpaMapper.class, IHabitacionJpaMapper.class })
public interface IDetalleServicioEstadiaJpaMapper {

    DetalleServicoEntity toEntity(DetalleServicioEstadia domain);

    @AfterMapping
    default void linkItemsToEntity(@MappingTarget DetalleServicoEntity entity) {
        if (entity.getItems() != null) {
            for (DetalleServicioItemEntity item : entity.getItems()) {
                item.setDetalleServicio(entity);
            }
        }
    }

    DetalleServicioEstadia toDomain(DetalleServicoEntity entity);

    @AfterMapping
    default void linkItemsToDomain(@MappingTarget DetalleServicioEstadia domain) {
        if (domain.getItems() != null) {
            for (DetalleServicioItem item : domain.getItems()) {
                item.setDetalleServicio(domain);
            }
        }
    }
    
    @Mapping(target = "detalleServicio", ignore = true)
    DetalleServicioItemEntity toItemEntity(DetalleServicioItem domain);
    
    @Mapping(target = "detalleServicio", ignore = true)
    DetalleServicioItem toItemDomain(DetalleServicioItemEntity entity);
}
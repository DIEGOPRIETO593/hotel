package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;
import com.proyecto.hotel.infraestructura.persistencia.jpa.DetalleServicioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") 
public interface IDetalleServicioEstadiaJpaMapper {

    @Mapping(source = "estadia.idEstadia", target = "idEstadia")
    @Mapping(source = "catalogoServicio.idServicio", target = "idServicio")
	DetalleServicioEstadia toDomain(DetalleServicioEntity entity);
	
    @Mapping(source = "idEstadia", target = "estadia.idEstadia")
    @Mapping(source = "idServicio", target = "catalogoServicio.idServicio")
	DetalleServicioEntity toEntity(DetalleServicioEstadia domain);
}
package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.proyecto.hotel.dominio.entidades.Estadia;
import com.proyecto.hotel.infraestructura.persistencia.jpa.EstadiaEntity;

@Mapper(componentModel = "spring")
public interface IEstadiaJpaMapper {

    @Mapping(source = "huesped.idHuesped", target = "idHuesped")
    @Mapping(source = "habitacion.idHabitacion", target = "idHabitacion")
	Estadia toDomain(EstadiaEntity entity);
	
    @Mapping(source = "idHuesped", target = "huesped.idHuesped")
    @Mapping(source = "idHabitacion", target = "habitacion.idHabitacion")
	EstadiaEntity toEntity(Estadia domain);
}
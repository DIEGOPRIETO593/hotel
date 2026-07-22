package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Habitacion;
import com.proyecto.hotel.infraestructura.persistencia.jpa.HabitacionEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IHabitacionJpaMapper {

    @org.mapstruct.Mapping(source = "numero", target = "numero_habitacion")
    @org.mapstruct.Mapping(source = "estado", target = "estado_habitacion")
    @org.mapstruct.Mapping(source = "piso", target = "piso_habitacion")
    @org.mapstruct.Mapping(source = "estrellas", target = "estrellas_habitacion")
    @org.mapstruct.Mapping(source = "capacidad", target = "capacidad_habitacion")
	Habitacion toDomain(HabitacionEntity entity);
	
    @org.mapstruct.Mapping(source = "numero_habitacion", target = "numero")
    @org.mapstruct.Mapping(source = "estado_habitacion", target = "estado")
    @org.mapstruct.Mapping(source = "piso_habitacion", target = "piso")
    @org.mapstruct.Mapping(source = "estrellas_habitacion", target = "estrellas")
    @org.mapstruct.Mapping(source = "capacidad_habitacion", target = "capacidad")
	HabitacionEntity toEntity(Habitacion domain);
}

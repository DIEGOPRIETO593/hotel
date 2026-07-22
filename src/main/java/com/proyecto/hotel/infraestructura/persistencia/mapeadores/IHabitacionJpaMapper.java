package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Habitacion;
import com.proyecto.hotel.infraestructura.persistencia.jpa.HabitacionEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IHabitacionJpaMapper {
	Habitacion toDomain(HabitacionEntity entity);
	HabitacionEntity toEntity(Habitacion domain);
}

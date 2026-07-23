package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Estadia;
import com.proyecto.hotel.infraestructura.persistencia.jpa.EstadiaEntity;

@Mapper(componentModel = "Spring", uses = { IHuespedJpaMapper.class, IHabitacionJpaMapper.class })
public interface IEstadiaJpaMapper {

	Estadia toDomain(EstadiaEntity entity);
	
	EstadiaEntity toEntity(Estadia domain);
}
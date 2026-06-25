package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Huesped;
import com.proyecto.hotel.infraestructura.persistencia.jpa.HuespedEntity;

@Mapper(componentModel = "Spring")
public interface IHuespedJpaMapper {

	// Transforma un Entity de la BD a un objeto de Dominio
	Huesped toDomain(HuespedEntity entity);
	
	// Mapea un objeto de Dominio a un Entity de la BD
	HuespedEntity toEntity(Huesped domain);
}
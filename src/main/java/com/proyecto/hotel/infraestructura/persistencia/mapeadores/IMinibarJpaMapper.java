package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Minibar;
import com.proyecto.hotel.infraestructura.persistencia.jpa.MinibarEntity;

@Mapper(componentModel = "Spring")
public interface IMinibarJpaMapper {

	// Transforma un Entity de la BD a un objeto de Dominio
	Minibar toDomain(MinibarEntity entity);
	
	// Mapea un objeto de Dominio a un Entity de la BD
	MinibarEntity toEntity(Minibar domain);
}
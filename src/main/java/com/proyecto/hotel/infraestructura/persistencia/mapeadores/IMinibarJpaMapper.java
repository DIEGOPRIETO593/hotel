package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Minibar;
import com.proyecto.hotel.infraestructura.persistencia.jpa.MinibarEntity;

@Mapper(componentModel = "spring", uses = {IMinibarDetalleJpaMapper.class})
public interface IMinibarJpaMapper {

	Minibar toDomain(MinibarEntity entity);
	
	MinibarEntity toEntity(Minibar domain);
}
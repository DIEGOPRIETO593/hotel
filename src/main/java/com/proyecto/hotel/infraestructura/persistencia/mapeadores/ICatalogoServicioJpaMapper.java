package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.CatalogoServicio;
import com.proyecto.hotel.infraestructura.persistencia.jpa.CatalogoEntity;

@Mapper(componentModel = "Spring")
public interface ICatalogoServicioJpaMapper {

	CatalogoServicio toDomain(CatalogoEntity entity);
	
	CatalogoEntity toEntity(CatalogoServicio domain);
}
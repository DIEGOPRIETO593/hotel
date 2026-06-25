package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;
import com.proyecto.hotel.infraestructura.persistencia.jpa.DetalleServicoEntity; // <-- Nota que aquí dice "Servico" (sin la 'i')
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") 
public interface IDetalleServicioEstadiaJpaMapper {

	DetalleServicioEstadia toDomain(DetalleServicoEntity entity);
	
	
	DetalleServicoEntity toEntity(DetalleServicioEstadia domain);
}
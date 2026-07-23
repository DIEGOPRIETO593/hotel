package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;
import com.proyecto.hotel.presentacion.dto.request.DetalleServicioEstadiaRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.DetalleServicioEstadiaResponseDTO;

@Mapper(componentModel = "spring")
public interface IDetalleServicioEstadiaDtoMapper {
	
	
	
	@Mapping(target = "estadia.idEstadia", source = "idEstadia")
    @Mapping(target = "catalogo.idServicio", source = "idServicio")
    DetalleServicioEstadia toDomain(DetalleServicioEstadiaRequestDTO dto);

    
    @Mapping(target = "idEstadia", source = "estadia.idEstadia")
    @Mapping(target = "idServicio", source = "catalogo.idServicio")
    DetalleServicioEstadiaResponseDTO toResponseDto(DetalleServicioEstadia entity);
}

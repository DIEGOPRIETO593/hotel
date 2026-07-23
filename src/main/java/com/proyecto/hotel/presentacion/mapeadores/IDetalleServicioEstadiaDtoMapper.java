package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;
import com.proyecto.hotel.presentacion.dto.request.DetalleServicioEstadiaRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.DetalleServicioEstadiaResponseDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IDetalleServicioEstadiaDtoMapper {
	DetalleServicioEstadia toDomain(DetalleServicioEstadiaRequestDTO dto);
    DetalleServicioEstadiaResponseDTO toResponseDto(DetalleServicioEstadia entity);
}

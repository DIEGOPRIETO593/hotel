package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.proyecto.hotel.dominio.entidades.Estadia;
import com.proyecto.hotel.presentacion.dto.request.EstadiaRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.EstadiaResponseDTO;

@Mapper(componentModel = "spring")
public interface IEstadiaDtoMapper {

	Estadia toDomain(EstadiaRequestDTO dto);

	EstadiaResponseDTO toResponseDto(Estadia entity);
}

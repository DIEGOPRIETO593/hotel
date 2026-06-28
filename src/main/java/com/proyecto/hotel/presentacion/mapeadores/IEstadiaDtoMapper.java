package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.proyecto.hotel.dominio.entidades.Estadia;
import com.proyecto.hotel.presentacion.dto.request.EstadiaRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.EstadiaResponseDTO;

@Mapper(componentModel = "spring")
public interface IEstadiaDtoMapper {

	@Mapping(target = "huesped.idHuesped", source = "idHuesped")
    @Mapping(target = "habitacion.idhabitacion", source = "idHabitacion")
	Estadia toDomain(EstadiaRequestDTO dto);

	@Mapping(target = "idHuesped", source = "huesped.idHuesped")
    @Mapping(target = "idHabitacion", source = "habitacion.idhabitacion")
	EstadiaResponseDTO toResponseDto(Estadia entity);
}
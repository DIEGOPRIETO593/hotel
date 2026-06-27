 package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.proyecto.hotel.dominio.entidades.CatalogoServicio;
import com.proyecto.hotel.dominio.entidades.Huesped;
import com.proyecto.hotel.presentacion.dto.request.HuespedRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.HuespedResponseDTO;

@Mapper(componentModel = "spring")
public interface IHuespedDtoMapper {
	Huesped toDomain(HuespedRequestDTO dto);
    HuespedResponseDTO toResponseDto(Huesped servicioPojo);
}

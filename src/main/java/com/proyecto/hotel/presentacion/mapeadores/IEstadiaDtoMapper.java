package com.proyecto.hotel.presentacion.mapeadores;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @Mapping(target = "nombreHuesped", expression = "java(entity.getHuesped() != null ? entity.getHuesped().getNombre() + \" \" + entity.getHuesped().getApellido() : null)")
    @Mapping(target = "numeroHabitacion", expression = "java(entity.getHabitacion() != null ? String.valueOf(entity.getHabitacion().getNumero()) : null)")
	EstadiaResponseDTO toResponseDto(Estadia entity);
	
	
}
package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.proyecto.hotel.dominio.entidades.Habitacion;
import com.proyecto.hotel.presentacion.dto.request.HabitacionRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.HabitacionResponseDTO;

@Mapper(componentModel = "spring")
public interface IHabitacionDtoMapper {
    
    @Mapping(source = "idHabitacion", target = "idhabitacion")
    Habitacion toDomain(HabitacionRequestDTO dto);

    @Mapping(source = "idhabitacion", target = "idHabitacion")
    HabitacionResponseDTO toResponseDto(Habitacion habitacionPojo);
}
package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Habitacion;
import com.proyecto.hotel.presentacion.dto.request.HabitacionRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.HabitacionResponseDTO;

@Mapper(componentModel = "spring")
public interface IHabitacionDtoMapper {
    
    Habitacion toDomain(HabitacionRequestDTO dto);
    HabitacionResponseDTO toResponseDto(Habitacion habitacionPojo);
}
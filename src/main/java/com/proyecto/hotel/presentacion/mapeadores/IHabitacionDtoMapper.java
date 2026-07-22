package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Habitacion;
import com.proyecto.hotel.presentacion.dto.request.HabitacionRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.HabitacionResponseDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IHabitacionDtoMapper {
    
    @org.mapstruct.Mapping(source = "numero", target = "numero_habitacion")
    @org.mapstruct.Mapping(source = "estado", target = "estado_habitacion")
    @org.mapstruct.Mapping(source = "piso", target = "piso_habitacion")
    @org.mapstruct.Mapping(source = "estrellas", target = "estrellas_habitacion")
    @org.mapstruct.Mapping(source = "capacidad", target = "capacidad_habitacion")
    @org.mapstruct.Mapping(source = "idHabitacion", target = "id_habitacion")
    Habitacion toDomain(HabitacionRequestDTO dto);
    
    @org.mapstruct.Mapping(source = "numero_habitacion", target = "numero")
    @org.mapstruct.Mapping(source = "estado_habitacion", target = "estado")
    @org.mapstruct.Mapping(source = "piso_habitacion", target = "piso")
    @org.mapstruct.Mapping(source = "estrellas_habitacion", target = "estrellas")
    @org.mapstruct.Mapping(source = "capacidad_habitacion", target = "capacidad")
    @org.mapstruct.Mapping(source = "id_habitacion", target = "idHabitacion")
    HabitacionResponseDTO toResponseDto(Habitacion habitacionPojo);
}

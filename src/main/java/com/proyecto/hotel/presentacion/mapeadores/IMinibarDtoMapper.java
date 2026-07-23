package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.proyecto.hotel.dominio.entidades.Minibar;
import com.proyecto.hotel.presentacion.dto.request.MinibarRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.MinibarResponseDTO;

@Mapper(componentModel = "spring")
public interface IMinibarDtoMapper {

    @Mapping(target = "habitacion.idhabitacion", source = "idHabitacion")
    @Mapping(target = "producto.idProducto", source = "idProducto")
    Minibar toDomain(MinibarRequestDTO dto);

    @Mapping(target = "idHabitacion", source = "habitacion.idhabitacion")
    @Mapping(target = "idProducto", source = "producto.idProducto")
    MinibarResponseDTO toResponseDto(Minibar domain);
}
package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.CatalogoServicio;
import com.proyecto.hotel.presentacion.dto.request.CatalogoServicioRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.CatalogoServicioResponseDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ICatalogoServicioDtoMapper {
    CatalogoServicio toDomain(CatalogoServicioRequestDTO dto);
    CatalogoServicioResponseDTO toResponseDto(CatalogoServicio servicioPojo);
}

package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.CatalogoServicio;
import com.proyecto.hotel.presentacion.dto.request.CatalogoServicioRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.CatalogoServicioResponseDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ICatalogoServicioDtoMapper {
    
    @org.mapstruct.Mapping(source = "idServicio", target = "id_servicio")
    @org.mapstruct.Mapping(source = "nombreServicio", target = "nombre_servicio")
    CatalogoServicio toDomain(CatalogoServicioRequestDTO dto);
    
    @org.mapstruct.Mapping(source = "id_servicio", target = "idServicio")
    @org.mapstruct.Mapping(source = "nombre_servicio", target = "nombreServicio")
    CatalogoServicioResponseDTO toResponseDto(CatalogoServicio servicioPojo);
}

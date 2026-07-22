package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;
import com.proyecto.hotel.presentacion.dto.request.DetalleServicioEstadiaRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.DetalleServicioEstadiaResponseDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IDetalleServicioEstadiaDtoMapper {
    
    @org.mapstruct.Mapping(source = "idDetalle", target = "id_detalle")
    @org.mapstruct.Mapping(source = "idEstadia", target = "id_estadia")
    @org.mapstruct.Mapping(source = "idServicio", target = "id_servicio")
	DetalleServicioEstadia toDomain(DetalleServicioEstadiaRequestDTO dto);
    
    @org.mapstruct.Mapping(source = "id_detalle", target = "idDetalle")
    @org.mapstruct.Mapping(source = "id_estadia", target = "idEstadia")
    @org.mapstruct.Mapping(source = "id_servicio", target = "idServicio")
    DetalleServicioEstadiaResponseDTO toResponseDto(DetalleServicioEstadia entity);
}

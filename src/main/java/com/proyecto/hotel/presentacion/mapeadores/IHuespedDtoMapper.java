 package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.proyecto.hotel.dominio.entidades.Huesped;
import com.proyecto.hotel.presentacion.dto.request.HuespedRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.HuespedResponseDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IHuespedDtoMapper {
    @org.mapstruct.Mapping(source = "nombre", target = "nombre_huesped")
    @org.mapstruct.Mapping(source = "apellido", target = "apellido_huesped")
    @org.mapstruct.Mapping(source = "cedula", target = "cedula_huesped")
    @org.mapstruct.Mapping(source = "telefono", target = "telefono_huesed")
    @org.mapstruct.Mapping(source = "idHuesped", target = "id_huesped")
	Huesped toDomain(HuespedRequestDTO dto);

    @org.mapstruct.Mapping(source = "nombre_huesped", target = "nombre")
    @org.mapstruct.Mapping(source = "apellido_huesped", target = "apellido")
    @org.mapstruct.Mapping(source = "cedula_huesped", target = "cedula")
    @org.mapstruct.Mapping(source = "telefono_huesed", target = "telefono")
    @org.mapstruct.Mapping(source = "id_huesped", target = "idHuesped")
    HuespedResponseDTO toResponseDto(Huesped servicioPojo);
}

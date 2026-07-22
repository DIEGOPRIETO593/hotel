package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.proyecto.hotel.dominio.entidades.Estadia;
import com.proyecto.hotel.presentacion.dto.request.EstadiaRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.EstadiaResponseDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IEstadiaDtoMapper {

    @org.mapstruct.Mapping(source = "idEstadia", target = "id_estadia")
    @org.mapstruct.Mapping(source = "idHuesped", target = "id_huesped")
    @org.mapstruct.Mapping(source = "idHabitacion", target = "id_habitacion")
    @org.mapstruct.Mapping(source = "fechaIngreso", target = "fecha_ingreso")
    @org.mapstruct.Mapping(source = "fechaSalida", target = "fecha_salida")
    @org.mapstruct.Mapping(source = "cantidadHuespedes", target = "cantidad_huespedes")
    @org.mapstruct.Mapping(source = "totalPagar", target = "total_pagar")
	Estadia toDomain(EstadiaRequestDTO dto);

    @org.mapstruct.Mapping(source = "id_estadia", target = "idEstadia")
    @org.mapstruct.Mapping(source = "id_huesped", target = "idHuesped")
    @org.mapstruct.Mapping(source = "id_habitacion", target = "idHabitacion")
    @org.mapstruct.Mapping(source = "fecha_ingreso", target = "fechaIngreso")
    @org.mapstruct.Mapping(source = "fecha_salida", target = "fechaSalida")
    @org.mapstruct.Mapping(source = "cantidad_huespedes", target = "cantidadHuespedes")
    @org.mapstruct.Mapping(source = "total_pagar", target = "totalPagar")
	EstadiaResponseDTO toResponseDto(Estadia entity);
}

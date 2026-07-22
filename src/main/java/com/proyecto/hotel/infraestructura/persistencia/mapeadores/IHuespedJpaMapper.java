package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Huesped;
import com.proyecto.hotel.infraestructura.persistencia.jpa.HuespedEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IHuespedJpaMapper {

	// Transforma un Entity de la BD a un objeto de Dominio
    @org.mapstruct.Mapping(source = "nombre", target = "nombre_huesped")
    @org.mapstruct.Mapping(source = "apellido", target = "apellido_huesped")
    @org.mapstruct.Mapping(source = "cedula", target = "cedula_huesped")
    @org.mapstruct.Mapping(source = "telefono", target = "telefono_huesed")
	Huesped toDomain(HuespedEntity entity);
	
	// Mapea un objeto de Dominio a un Entity de la BD
    @org.mapstruct.Mapping(source = "nombre_huesped", target = "nombre")
    @org.mapstruct.Mapping(source = "apellido_huesped", target = "apellido")
    @org.mapstruct.Mapping(source = "cedula_huesped", target = "cedula")
    @org.mapstruct.Mapping(source = "telefono_huesed", target = "telefono")
	HuespedEntity toEntity(Huesped domain);
}

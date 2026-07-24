package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;
import com.proyecto.hotel.presentacion.dto.request.DetalleServicioEstadiaRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.DetalleServicioEstadiaResponseDTO;

@Mapper(componentModel = "spring")
public interface IDetalleServicioEstadiaDtoMapper {
	
	
	
	@Mapping(target = "estadia.idEstadia", source = "idEstadia")
    @Mapping(target = "catalogo.idServicio", source = "idServicio")
    DetalleServicioEstadia toDomain(DetalleServicioEstadiaRequestDTO dto);

    
    @Mapping(target = "idEstadia", source = "estadia.idEstadia")
    @Mapping(target = "idServicio", source = "catalogo.idServicio")
    
    @Mapping(target = "nombreHuesped", expression = "java(entity.getEstadia() != null && entity.getEstadia().getHuesped() != null ? entity.getEstadia().getHuesped().getNombre() + \" \" + entity.getEstadia().getHuesped().getApellido() : null)")
    @Mapping(target = "numeroHabitacion", expression = "java(entity.getEstadia() != null && entity.getEstadia().getHabitacion() != null ? String.valueOf(entity.getEstadia().getHabitacion().getNumero()) : null)")
    @Mapping(target = "nombreServicio", expression = "java(entity.getCatalogo() != null ? entity.getCatalogo().getnombreServicio() : null)")
    DetalleServicioEstadiaResponseDTO toResponseDto(DetalleServicioEstadia entity);
}

package com.proyecto.hotel.presentacion.mapeadores;
import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Minibar;
import com.proyecto.hotel.presentacion.dto.request.MinibarRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.MinibarResponseDTO;
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IMinibarDtoMapper {
    @org.mapstruct.Mapping(source = "idMinibar", target = "id_minibar")
    @org.mapstruct.Mapping(source = "idHabitacion", target = "id_habitacion")
    @org.mapstruct.Mapping(source = "idProducto", target = "id_producto")
    Minibar toDomain(MinibarRequestDTO dto);
    
    @org.mapstruct.Mapping(source = "id_minibar", target = "idMinibar")
    @org.mapstruct.Mapping(source = "id_habitacion", target = "idHabitacion")
    @org.mapstruct.Mapping(source = "id_producto", target = "idProducto")
    MinibarResponseDTO toResponseDto(Minibar entity);
}

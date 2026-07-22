package com.proyecto.hotel.presentacion.mapeadores;
import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Minibar;
import com.proyecto.hotel.presentacion.dto.request.MinibarRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.MinibarResponseDTO;
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IMinibarDtoMapper {
    Minibar toDomain(MinibarRequestDTO dto);
    MinibarResponseDTO toResponseDto(Minibar entity);
}

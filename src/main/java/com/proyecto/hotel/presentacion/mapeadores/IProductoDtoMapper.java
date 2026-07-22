package com.proyecto.hotel.presentacion.mapeadores;
import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Producto;
import com.proyecto.hotel.presentacion.dto.request.ProductoRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.ProductoResponseDTO;
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IProductoDtoMapper {
    Producto toDomain(ProductoRequestDTO dto);
    ProductoResponseDTO toResponseDto(Producto entity);
}

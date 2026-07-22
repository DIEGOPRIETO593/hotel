package com.proyecto.hotel.presentacion.mapeadores;
import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Producto;
import com.proyecto.hotel.presentacion.dto.request.ProductoRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.ProductoResponseDTO;
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IProductoDtoMapper {
    @org.mapstruct.Mapping(source = "idProducto", target = "id_producto")
    Producto toDomain(ProductoRequestDTO dto);
    
    @org.mapstruct.Mapping(source = "id_producto", target = "idProducto")
    ProductoResponseDTO toResponseDto(Producto entity);
}

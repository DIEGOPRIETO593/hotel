package com.proyecto.hotel.infraestructura.persistencia.mapeadores;
import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Producto;
import com.proyecto.hotel.infraestructura.persistencia.jpa.ProductoEntity;
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IProductoJpaMapper {
    Producto toDomain(ProductoEntity entity);
    ProductoEntity toEntity(Producto domain);
}

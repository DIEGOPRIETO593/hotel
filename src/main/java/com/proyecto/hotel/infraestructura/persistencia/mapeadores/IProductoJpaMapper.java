package com.proyecto.hotel.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Producto;
import com.proyecto.hotel.infraestructura.persistencia.jpa.ProductoEntity;

@Mapper(componentModel = "Spring")
public interface IProductoJpaMapper {

	// Transforma un Entity de la BD a un objeto de Dominio
	Producto toDomain(ProductoEntity entity);
	
	// Mapea un objeto de Dominio a un Entity de la BD
	ProductoEntity toEntity(Producto domain);
}
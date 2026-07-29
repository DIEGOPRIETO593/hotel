package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.proyecto.hotel.dominio.entidades.Minibar;
import com.proyecto.hotel.dominio.entidades.MinibarDetalle;
import com.proyecto.hotel.dominio.entidades.Producto;
import com.proyecto.hotel.presentacion.dto.request.MinibarRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.MinibarResponseDTO;
import com.proyecto.hotel.presentacion.dto.response.MinibarDetalleResponseDTO;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IMinibarDtoMapper {

    @Mapping(target = "habitacion.idhabitacion", source = "idHabitacion")
    @Mapping(target = "detalles", ignore = true)
    Minibar toDomain(MinibarRequestDTO dto);

    @AfterMapping
    default void mapDetalles(MinibarRequestDTO dto, @MappingTarget Minibar minibar) {
        if (dto.getIdProductos() != null && dto.getCantidades() != null 
            && dto.getIdProductos().size() == dto.getCantidades().size()) {
            
            List<MinibarDetalle> detalles = new ArrayList<>();
            for (int i = 0; i < dto.getIdProductos().size(); i++) {
                MinibarDetalle detalle = new MinibarDetalle();
                Producto p = new Producto();
                p.setIdProducto(dto.getIdProductos().get(i));
                detalle.setProducto(p);
                detalle.setCantidad(dto.getCantidades().get(i));
                detalle.setMinibar(minibar);
                detalles.add(detalle);
            }
            minibar.setDetalles(detalles);
        }
    }

    @Mapping(target = "idHabitacion", source = "habitacion.idhabitacion")
    @Mapping(target = "numeroHabitacion", source = "habitacion.numero")
    @Mapping(target = "total", ignore = true)
    MinibarResponseDTO toResponseDto(Minibar domain);

    @AfterMapping
    default void calculateTotal(Minibar domain, @MappingTarget MinibarResponseDTO responseDto) {
        double total = 0.0;
        if (domain.getDetalles() != null) {
            for (MinibarDetalle detalle : domain.getDetalles()) {
                if (detalle.getProducto() != null) {
                    total += detalle.getCantidad() * detalle.getProducto().getPrecio();
                }
            }
        }
        responseDto.setTotal(total);
    }

    @Mapping(target = "idProducto", source = "producto.idProducto")
    @Mapping(target = "nombreProducto", source = "producto.nombre")
    @Mapping(target = "precioUnitario", source = "producto.precio")
    @Mapping(target = "subtotal", expression = "java(detalle.getProducto() != null ? (double) (detalle.getCantidad() * detalle.getProducto().getPrecio()) : 0.0)")
    MinibarDetalleResponseDTO toDetalleResponseDto(MinibarDetalle detalle);
}
package com.proyecto.hotel.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;

import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;
import com.proyecto.hotel.dominio.entidades.DetalleServicioItem;
import com.proyecto.hotel.dominio.entidades.CatalogoServicio;
import com.proyecto.hotel.presentacion.dto.request.DetalleServicioEstadiaRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.DetalleServicioEstadiaResponseDTO;
import com.proyecto.hotel.presentacion.dto.response.DetalleServicioItemResponseDTO;
import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface IDetalleServicioEstadiaDtoMapper {
	
	@Mapping(target = "estadia.idEstadia", source = "idEstadia")
    DetalleServicioEstadia toDomain(DetalleServicioEstadiaRequestDTO dto);

    @AfterMapping
    default void mapItems(DetalleServicioEstadiaRequestDTO dto, @MappingTarget DetalleServicioEstadia entity) {
        if (dto.getIdServicios() != null && dto.getCantidades() != null && dto.getTotales() != null) {
            entity.setItems(new ArrayList<>());
            double totalGeneral = 0.0;
            for (int i = 0; i < dto.getIdServicios().size(); i++) {
                DetalleServicioItem item = new DetalleServicioItem();
                CatalogoServicio cs = new CatalogoServicio();
                cs.setidServicio(dto.getIdServicios().get(i));
                item.setCatalogoServicio(cs);
                item.setCantidad(dto.getCantidades().get(i));
                item.setTotal(dto.getTotales().get(i));
                item.setDetalleServicio(entity);
                entity.getItems().add(item);
                totalGeneral += item.getTotal();
            }
            entity.setTotal(totalGeneral);
        }
    }

    @Mapping(target = "idEstadia", source = "estadia.idEstadia")
    @Mapping(target = "nombreHuesped", expression = "java(entity.getEstadia() != null && entity.getEstadia().getHuesped() != null ? entity.getEstadia().getHuesped().getNombre() + \" \" + entity.getEstadia().getHuesped().getApellido() : null)")
    @Mapping(target = "numeroHabitacion", expression = "java(entity.getEstadia() != null && entity.getEstadia().getHabitacion() != null ? String.valueOf(entity.getEstadia().getHabitacion().getNumero()) : null)")
    DetalleServicioEstadiaResponseDTO toResponseDto(DetalleServicioEstadia entity);

    @Mapping(target = "idServicio", source = "catalogoServicio.idServicio")
    @Mapping(target = "nombreServicio", expression = "java(item.getCatalogoServicio() != null ? item.getCatalogoServicio().getnombreServicio() : null)")
    DetalleServicioItemResponseDTO itemToResponseDto(DetalleServicioItem item);
}

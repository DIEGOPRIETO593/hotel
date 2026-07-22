package com.proyecto.hotel.infraestructura.persistencia.mapeadores;
import org.mapstruct.Mapper;
import com.proyecto.hotel.dominio.entidades.Minibar;
import com.proyecto.hotel.infraestructura.persistencia.jpa.MinibarEntity;
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IMinibarJpaMapper {
    @org.mapstruct.Mapping(source = "habitacion.id_habitacion", target = "id_habitacion")
    @org.mapstruct.Mapping(source = "producto.id_producto", target = "id_producto")
    Minibar toDomain(MinibarEntity entity);
    
    @org.mapstruct.Mapping(source = "id_habitacion", target = "habitacion.id_habitacion")
    @org.mapstruct.Mapping(source = "id_producto", target = "producto.id_producto")
    MinibarEntity toEntity(Minibar domain);
}

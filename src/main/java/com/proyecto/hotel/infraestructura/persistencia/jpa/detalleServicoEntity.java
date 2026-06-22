package com.proyecto.hotel.infraestructura.persistencia.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "detalle_servicio_estadia")
public class detalleServicoEntity {
	
	@Id
    private int id_detalle;

    @Column(name = "detalle_id_estadia")
    private int id_estadia;

    @Column(name = "detalle_id_servicio")
    private int id_servicio;

    @Column(name = "detalle_cantidad", length = 3)
    private int cantidad;

    @Column(name = "detalle_subtotal")
    private double subtotal;
}

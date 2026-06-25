package com.proyecto.hotel.infraestructura.persistencia.jpa;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "estadia")
public class EstadiaEntity {

	
	@Id
    private int id_estadia;

    @Column(name = "estadia_id_huesped")
    private int id_huesped;

    @Column(name = "estadia_id_habitacion")
    private int id_habitacion;

    @Column(name = "estadia_fecha_ingreso")
    private Date fecha_ingreso;

    @Column(name = "estadia_fecha_salida")
    private Date fecha_salida;

    @Column(name = "estadia_cantidad_huespedes", length = 2)
    private int cantidad_huespedes;

    @Column(name = "estadia_total_pagar")
    private double total_pagar;
    
}

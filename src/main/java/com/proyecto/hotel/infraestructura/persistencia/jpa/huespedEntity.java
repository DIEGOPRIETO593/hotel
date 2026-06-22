package com.proyecto.hotel.infraestructura.persistencia.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "huesped")
public class huespedEntity {
 
	@Id
    private int id_huesped;

    @Column(name = "huesped_cedula", length = 10)
    private String cedula;

    @Column(name = "huesped_nombre", length = 80)
    private String nombre;

    @Column(name = "huesped_apellido", length = 80)
    private String apellido;

    @Column(name = "huesped_telefono", length = 10)
    private String telefono;
}

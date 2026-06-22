package com.proyecto.hotel.infraestructura.persistencia.jpa;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "catalogo_servicio")
public class catalogoEntity {
	

	    @Id
	    private int id_servicio;

	    @Column(name = "servicio_nombre", length = 100)
	    private String nombre_servicio;

	    @Column(name = "servicio_tarifa")
	    private double tarifa; 
	

}

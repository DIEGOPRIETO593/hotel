package com.proyecto.hotel.infraestructura.persistencia.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data 
@Entity
@Table(name = "habitacion")

public class HabitacionEntity {

    @Id
    private int id_habitacion;

    @Column(name = "habitacion_numero", length = 10)
    private String numero;

    @Column(name = "habitacion_estado", length = 30)
    private String estado;

    @Column(name = "habitacion_piso", length = 2)
    private int piso;

    @Column(name = "habitacion_estrellas", length = 1)
    private int estrellas;

    @Column(name = "habitacion_capacidad", length = 2)
    private int capacidad;
}

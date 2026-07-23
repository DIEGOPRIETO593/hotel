package com.proyecto.hotel.infraestructura.persistencia.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data 
@Entity
@Table(name = "habitacion")
public class HabitacionEntity {

    @Id
    @Column(name = "id_habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)     
    private int idhabitacion;

    @Column(name = "numero", length = 10)
    private String numero;

    @Column(name = "estado", length = 30) 
    private String estado;

    @Column(name = "piso") 
    private Integer piso;

    @Column(name = "estrellas") 
    private Integer estrellas;

    @Column(name = "capacidad")
    private Integer capacidad;
}
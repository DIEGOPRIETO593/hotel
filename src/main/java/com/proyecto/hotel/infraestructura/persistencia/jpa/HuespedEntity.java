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
@Table(name = "huesped")
public class HuespedEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_huesped")
    private int idHuesped;

    @Column(name = "cedula", length = 10, unique = true)
    private String cedula;

    @Column(name = "nombre", length = 80)
    private String nombre;

    @Column(name = "apellido", length = 80)
    private String apellido;

    @Column(name = "telefono", length = 10)
    private String telefono;
}
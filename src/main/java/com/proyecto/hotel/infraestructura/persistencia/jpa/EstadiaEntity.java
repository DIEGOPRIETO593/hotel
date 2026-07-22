package com.proyecto.hotel.infraestructura.persistencia.jpa;

import java.time.LocalDateTime; // Cambiado a LocalDateTime ya que en tu diagrama es TIMESTAMP
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "estadia")
public class EstadiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_estadia")
    private int id_estadia;

    @Column(name = "id_huesped")
    private int id_huesped;

    @Column(name = "id_habitacion")
    private int id_habitacion;

    @Column(name = "fecha_ingreso") 
    private LocalDateTime fecha_ingreso;

    @Column(name = "fecha_salida") 
    private LocalDateTime fecha_salida;

    @Column(name = "cantidad_huespedes") 
    private int cantidad_huespedes;

    @Column(name = "total_pagar")
    private double total_pagar;
    
}
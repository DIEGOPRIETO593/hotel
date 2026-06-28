package com.proyecto.hotel.infraestructura.persistencia.jpa;

import java.time.LocalDateTime; 
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
    private int idEstadia;

    @Column(name = "id_huesped")
    private int idHuesped;

    @Column(name = "id_habitacion")
    private int idHabitacion;

    @Column(name = "fecha_ingreso") 
    private LocalDateTime fechaIngreso;

    @Column(name = "fecha_salida") 
    private LocalDateTime fechaSalida;

    @Column(name = "cantidad_huespedes") 
    private int cantidadHuespedes;

    @Column(name = "total_pagar")
    private double totalPagar;
    
}
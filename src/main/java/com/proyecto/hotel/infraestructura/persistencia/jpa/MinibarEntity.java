package com.proyecto.hotel.infraestructura.persistencia.jpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "minibar")
public class MinibarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_minibar")
    private int idMinibar;

    @ManyToOne
    @JoinColumn(name = "id_habitacion", nullable = false)
    private HabitacionEntity habitacion;

    @Column(name = "estado", length = 30)
    private String estado;

    @OneToMany(mappedBy = "minibar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MinibarDetalleEntity> detalles;
}
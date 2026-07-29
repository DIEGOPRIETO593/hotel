package com.proyecto.hotel.infraestructura.persistencia.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle_servicio_item")
public class DetalleServicioItemEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private int idItem;

    @ManyToOne
    @JoinColumn(name = "id_detalle", referencedColumnName = "id_detalle", nullable = false)
    private DetalleServicoEntity detalleServicio;

    @ManyToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false)
    private CatalogoEntity catalogoServicio;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "total")
    private double total;
}

package com.proyecto.hotel.infraestructura.persistencia.jpa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;
@Data
@Entity
@Table(name = "minibar")
public class MinibarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_minibar")
    private int id_minibar;
    
    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id_habitacion", nullable = false)
    private HabitacionEntity habitacion;
    
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false)
    private ProductoEntity producto;
    
    @Column(name = "cantidad")
    private int cantidad;
}

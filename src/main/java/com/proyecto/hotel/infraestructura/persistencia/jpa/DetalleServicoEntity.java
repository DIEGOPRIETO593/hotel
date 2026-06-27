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
@Table(name = "detalle_servicio_estadia")
public class DetalleServicoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle") 
	private int id_detalle;

	@ManyToOne
	@JoinColumn(name = "id_estadia", referencedColumnName = "id_estadia", nullable = false)
	private EstadiaEntity estadia;

	@ManyToOne
	@JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false)
	private CatalogoEntity catalogoServicio;

	@Column(name = "cantidad") 
	private int cantidad;

	@Column(name = "subtotal") 
	private double subtotal;
}
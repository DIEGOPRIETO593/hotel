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
import java.util.ArrayList;

@Data
@Entity
@Table(name = "detalle_servicio_estadia")
public class DetalleServicoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle") 
	private int idDetalle;

	@ManyToOne
	@JoinColumn(name = "id_estadia", referencedColumnName = "id_estadia", nullable = true)
	@org.hibernate.annotations.NotFound(action = org.hibernate.annotations.NotFoundAction.IGNORE)
	private EstadiaEntity estadia;

	@Column(name = "total")
	private double total;

	@Column(name = "estado", length = 30)
	private String estado;

	@OneToMany(mappedBy = "detalleServicio", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleServicioItemEntity> items = new ArrayList<>();
}

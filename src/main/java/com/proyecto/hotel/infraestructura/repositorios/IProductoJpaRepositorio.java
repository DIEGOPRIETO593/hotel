package com.proyecto.hotel.infraestructura.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.hotel.dominio.entidades.Producto;
import com.proyecto.hotel.infraestructura.persistencia.jpa.ProductoEntity;

public interface IProductoJpaRepositorio extends JpaRepository<ProductoEntity, Integer>{


	

}

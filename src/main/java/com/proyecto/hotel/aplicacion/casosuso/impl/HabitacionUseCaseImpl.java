package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.excepciones.ResourceNotFoundException;

import com.proyecto.hotel.aplicacion.casosuso.entrada.IHabitacionUseCase;
import com.proyecto.hotel.dominio.entidades.Habitacion;
import com.proyecto.hotel.dominio.entidades.Huesped;
import com.proyecto.hotel.dominio.repositorios.IHabitacionRepositorio;

/**
 * Caso de uso: Implementación de la gestión del inventario de Habitaciones.
 * Capa: Aplicación (Clean Architecture).
 * Responsabilidad: Administrar el ciclo de vida de las habitaciones (crear, modificar, listar, eliminar)
 * garantizando la integridad referencial.
 */
public class HabitacionUseCaseImpl implements IHabitacionUseCase {

    private final IHabitacionRepositorio repositorio;

    public HabitacionUseCaseImpl(IHabitacionRepositorio repositorio) {
        super();
        this.repositorio = repositorio;
    }

    @Override
    public Habitacion guardar(Habitacion nuevaHabitacion) {
        boolean existe = listarTodos().stream().anyMatch(h -> h.getNumero().equals(nuevaHabitacion.getNumero()));
        if (existe) {
            throw new IllegalArgumentException("El número de habitación ingresado ya existe.");
        }
        return repositorio.guardar(nuevaHabitacion);
    }

    @Override
    public Habitacion buscarPorId(int idHabitacion) {
        return repositorio.buscarPorId(idHabitacion)
                .orElseThrow(() -> new ResourceNotFoundException("Habitación no encontrada"));
    }

    @Override
    public List<Habitacion> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idHabitacion) {
        buscarPorId(idHabitacion);

        repositorio.eliminar(idHabitacion);
    }

    @Override
    public List<Habitacion> buscarPorEstado(String estado) {
        return repositorio.buscarPorEstado(estado);
    }

	@Override
	public List<Habitacion> buscarCapacidad(int capacidad) {
		// TODO Auto-generated method stub
		return repositorio.buscarCapacidad(capacidad);
	}
	@Override
    public Habitacion actualizar(int idHabitacion, Habitacion datosActualizados) {
		Habitacion habitacionExistente = buscarPorId(idHabitacion);
		
		if (datosActualizados.getNumero() != null && !datosActualizados.getNumero().equals(habitacionExistente.getNumero())) {
            throw new IllegalArgumentException("El número de habitación no se puede modificar una vez registrado.");
        }
		
		if ("Ocupada".equalsIgnoreCase(habitacionExistente.getEstado())) {
            throw new IllegalArgumentException("No se puede modificar una habitación que se encuentra actualmente Ocupada en una estadía.");
        }
		
		habitacionExistente.setCapacidad(datosActualizados.getCapacidad());
		habitacionExistente.setEstado(datosActualizados.getEstado());
		habitacionExistente.setEstrellas(datosActualizados.getEstrellas());
		habitacionExistente.setPiso(datosActualizados.getPiso());
		habitacionExistente.setPrecio(datosActualizados.getPrecio());
        return repositorio.guardar(habitacionExistente);
    }

     
}
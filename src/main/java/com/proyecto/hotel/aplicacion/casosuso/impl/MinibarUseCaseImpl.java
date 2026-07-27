package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.excepciones.ResourceNotFoundException;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IMinibarUseCase;
import com.proyecto.hotel.dominio.entidades.Minibar;
import com.proyecto.hotel.dominio.repositorios.IMinibarRepositorio;

/**
 * Caso de uso: Implementación de la lógica de negocio para los consumos de Minibar.
 * Capa: Aplicación (Clean Architecture).
 * Responsabilidad: Gestionar el cargo de productos consumidos en las habitaciones y calcular sus montos totales.
 */
public class MinibarUseCaseImpl implements IMinibarUseCase {

    private final IMinibarRepositorio repositorio;

    public MinibarUseCaseImpl(IMinibarRepositorio repositorio) {
        super();
        this.repositorio = repositorio;
    }

    @Override
    public Minibar guardar(Minibar nuevoMinibar) {
        if (nuevoMinibar.getEstado() == null || nuevoMinibar.getEstado().trim().isEmpty()) {
            nuevoMinibar.setEstado("Por Cobrar");
        }
        return repositorio.guardar(nuevoMinibar);
    }

    @Override
    public Minibar buscarPorId(int idMinibar) {
        return repositorio.buscarPorId(idMinibar)
                .orElseThrow(() -> new ResourceNotFoundException("Minibar no encontrado con el ID: " + idMinibar));
    }

    @Override
    public List<Minibar> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idMinibar) {
        buscarPorId(idMinibar);

        repositorio.eliminar(idMinibar);
    }

    @Override
    public Minibar actualizar(int idMinibar, Minibar datosActualizados) {
        Minibar minibarExistente = buscarPorId(idMinibar);
        
        if (datosActualizados.getHabitacion() != null) {
            minibarExistente.setHabitacion(datosActualizados.getHabitacion());
        }
        if (datosActualizados.getProducto() != null) {
            minibarExistente.setProducto(datosActualizados.getProducto());
        }
        if (datosActualizados.getCantidad() > 0) {
            minibarExistente.setCantidad(datosActualizados.getCantidad());
        }
        if (datosActualizados.getEstado() != null && !datosActualizados.getEstado().trim().isEmpty()) {
            minibarExistente.setEstado(datosActualizados.getEstado());
        }
        
        return repositorio.guardar(minibarExistente);
    }
}
package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IDetalleServicioEstadiaUseCase;
import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;
import com.proyecto.hotel.dominio.repositorios.IDetalleServicioEstadiaRepositorio;

public class DetalleServicioEstadiaUseCaseImpl implements IDetalleServicioEstadiaUseCase {

    private final IDetalleServicioEstadiaRepositorio repositorio;

    public DetalleServicioEstadiaUseCaseImpl(IDetalleServicioEstadiaRepositorio repositorio) {
        super();
        this.repositorio = repositorio;
    }

    @Override
    public DetalleServicioEstadia guardar(DetalleServicioEstadia nuevoDetalle) {
        return repositorio.guardar(nuevoDetalle);
    }

    @Override
    public DetalleServicioEstadia actualizar(int idDetalle, DetalleServicioEstadia detalleActualizado) {
        // 1. Validamos la existencia del registro antes de editar
        repositorio.buscarPorId(idDetalle)
                .orElseThrow(() -> new RuntimeException("Detalle de servicio no encontrado"));

        // 2. Inyectamos el ID original para que Spring Data JPA efectúe un UPDATE
        detalleActualizado.setIdDetalle(idDetalle);
        return repositorio.guardar(detalleActualizado);
    }

    @Override
    public DetalleServicioEstadia buscarPorId(int idDetalle) {
        return repositorio.buscarPorId(idDetalle)
                .orElseThrow(() -> new RuntimeException("Detalle de servicio de estadía no encontrado"));
    }

    @Override
    public List<DetalleServicioEstadia> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idDetalle) {
        if (!repositorio.buscarPorId(idDetalle).isPresent()) {
            throw new RuntimeException("Detalle de servicio de estadía no encontrado");
        }
        repositorio.eliminar(idDetalle);
    }
}
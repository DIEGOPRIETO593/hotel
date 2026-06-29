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
        repositorio.buscarPorId(idDetalle)
                .orElseThrow(() -> new RuntimeException("Detalle de servicio no encontrado"));

        estadiaRepositorio.buscarPorId(detalleActualizado.getIdEstadia())
                .orElseThrow(() -> new RuntimeException("La estadía con ID " + detalleActualizado.getIdEstadia() + " no existe."));

        catalogoRepositorio.buscarPorId(detalleActualizado.getIdServicio())
                .orElseThrow(() -> new RuntimeException("El servicio con ID " + detalleActualizado.getIdServicio() + " no existe."));

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
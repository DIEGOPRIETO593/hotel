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
        repositorio.eliminar(idDetalle);
    }
}
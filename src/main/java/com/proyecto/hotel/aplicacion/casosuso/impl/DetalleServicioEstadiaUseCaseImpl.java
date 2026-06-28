package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IDetalleServicioEstadiaUseCase;
import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;
import com.proyecto.hotel.dominio.entidades.Estadia;
import com.proyecto.hotel.dominio.entidades.CatalogoServicio;
import com.proyecto.hotel.dominio.repositorios.IDetalleServicioEstadiaRepositorio;
import com.proyecto.hotel.dominio.repositorios.IEstadiaRepositorio;
import com.proyecto.hotel.dominio.repositorios.ICatalogoServicioRepositorio;

public class DetalleServicioEstadiaUseCaseImpl implements IDetalleServicioEstadiaUseCase {

    private final IDetalleServicioEstadiaRepositorio repositorio;
    private final IEstadiaRepositorio estadiaRepositorio;
    private final ICatalogoServicioRepositorio catalogoRepositorio;

    public DetalleServicioEstadiaUseCaseImpl(IDetalleServicioEstadiaRepositorio repositorio,
                                             IEstadiaRepositorio estadiaRepositorio,
                                             ICatalogoServicioRepositorio catalogoRepositorio) {
        super();
        this.repositorio = repositorio;
        this.estadiaRepositorio = estadiaRepositorio;
        this.catalogoRepositorio = catalogoRepositorio;
    }

    @Override
    public DetalleServicioEstadia guardar(DetalleServicioEstadia nuevoDetalle) {
        Estadia estadiaReal = estadiaRepositorio.buscarPorId(nuevoDetalle.getEstadia().getIdEstadia())
                .orElseThrow(() -> new RuntimeException("La estadía especificada no existe"));

        CatalogoServicio servicioReal = catalogoRepositorio.buscarPorId(nuevoDetalle.getCatalogo().getidServicio())
                .orElseThrow(() -> new RuntimeException("El servicio especificado no existe"));

        nuevoDetalle.setEstadia(estadiaReal);
        nuevoDetalle.setCatalogo(servicioReal);

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
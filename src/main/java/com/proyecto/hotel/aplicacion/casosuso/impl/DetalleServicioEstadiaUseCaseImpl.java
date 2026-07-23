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
        estadiaRepositorio.buscarPorId(nuevoDetalle.getId_estadia())
                .orElseThrow(() -> new RuntimeException("La estadía especificada no existe"));

        catalogoRepositorio.buscarPorId(nuevoDetalle.getId_servicio())
                .orElseThrow(() -> new RuntimeException("El servicio especificado no existe"));

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
    
    @Override
    public DetalleServicioEstadia actualizar(int idDetalle, DetalleServicioEstadia datosActualizados) {
    	DetalleServicioEstadia detalleExistente = buscarPorId(idDetalle);
    	detalleExistente.setCantidad(datosActualizados.getCantidad());
    	detalleExistente.setId_servicio(datosActualizados.getId_servicio());
    	detalleExistente.setId_estadia(datosActualizados.getId_estadia());
    	detalleExistente.setId_detalle(datosActualizados.getId_detalle());
    	detalleExistente.setSubtotal(datosActualizados.getSubtotal());
        return repositorio.guardar(detalleExistente);
    }
}
package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.excepciones.ResourceNotFoundException;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IDetalleServicioEstadiaUseCase;
import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;
import com.proyecto.hotel.dominio.entidades.DetalleServicioItem;
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
        if (nuevoDetalle.getEstado() == null || nuevoDetalle.getEstado().trim().isEmpty()) {
            nuevoDetalle.setEstado("Por Cobrar");
        }
        Estadia estadiaReal = estadiaRepositorio.buscarPorId(nuevoDetalle.getEstadia().getIdEstadia())
                .orElseThrow(() -> new ResourceNotFoundException("La estadía especificada no existe"));

        nuevoDetalle.setEstadia(estadiaReal);

        if (nuevoDetalle.getItems() != null) {
            for (DetalleServicioItem item : nuevoDetalle.getItems()) {
                CatalogoServicio servicioReal = catalogoRepositorio.buscarPorId(item.getCatalogoServicio().getidServicio())
                        .orElseThrow(() -> new ResourceNotFoundException("El servicio especificado no existe"));
                item.setCatalogoServicio(servicioReal);
                item.setDetalleServicio(nuevoDetalle);
            }
        }

        return repositorio.guardar(nuevoDetalle);
    }

    @Override
    public DetalleServicioEstadia buscarPorId(int idDetalle) {
        return repositorio.buscarPorId(idDetalle)
                .orElseThrow(() -> new ResourceNotFoundException("Detalle de servicio de estadía no encontrado"));
    }

    @Override
    public List<DetalleServicioEstadia> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idDetalle) {
        buscarPorId(idDetalle);
        repositorio.eliminar(idDetalle);
    }
    
    @Override
    public DetalleServicioEstadia actualizar(int idDetalle, DetalleServicioEstadia datosActualizados) {
    	DetalleServicioEstadia detalleExistente = buscarPorId(idDetalle);
    	
        if (datosActualizados.getEstadia() != null && datosActualizados.getEstadia().getIdEstadia() > 0) {
            Estadia estadiaReal = estadiaRepositorio.buscarPorId(datosActualizados.getEstadia().getIdEstadia())
                .orElseThrow(() -> new ResourceNotFoundException("La estadía especificada no existe"));
            detalleExistente.setEstadia(estadiaReal);
        }

        if (datosActualizados.getItems() != null && !datosActualizados.getItems().isEmpty()) {
            detalleExistente.getItems().clear();
            for (DetalleServicioItem item : datosActualizados.getItems()) {
                CatalogoServicio servicioReal = catalogoRepositorio.buscarPorId(item.getCatalogoServicio().getidServicio())
                        .orElseThrow(() -> new ResourceNotFoundException("El servicio especificado no existe"));
                item.setCatalogoServicio(servicioReal);
                item.setDetalleServicio(detalleExistente);
                detalleExistente.getItems().add(item);
            }
            detalleExistente.setTotal(datosActualizados.getTotal());
        }

        if (datosActualizados.getEstado() != null && !datosActualizados.getEstado().trim().isEmpty()) {
            detalleExistente.setEstado(datosActualizados.getEstado());
        }
    	
        return repositorio.guardar(detalleExistente);
    }
}

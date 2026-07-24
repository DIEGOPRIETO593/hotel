package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.excepciones.ResourceNotFoundException;
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
                .orElseThrow(() -> new ResourceNotFoundException("La estadía especificada no existe"));

        CatalogoServicio servicioReal = catalogoRepositorio.buscarPorId(nuevoDetalle.getCatalogo().getidServicio())
                .orElseThrow(() -> new ResourceNotFoundException("El servicio especificado no existe"));

        nuevoDetalle.setEstadia(estadiaReal);
        nuevoDetalle.setCatalogo(servicioReal);

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

        if (datosActualizados.getCatalogo() != null && datosActualizados.getCatalogo().getidServicio() > 0) {
            CatalogoServicio servicioReal = catalogoRepositorio.buscarPorId(datosActualizados.getCatalogo().getidServicio())
                .orElseThrow(() -> new ResourceNotFoundException("El servicio especificado no existe"));
            detalleExistente.setCatalogo(servicioReal);
        }
        
    	detalleExistente.setCantidad(datosActualizados.getCantidad());
    	detalleExistente.setTotal(datosActualizados.getTotal());
    	
        return repositorio.guardar(detalleExistente);
    }
}

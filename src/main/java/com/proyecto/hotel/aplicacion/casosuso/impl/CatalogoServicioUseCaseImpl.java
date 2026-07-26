package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.excepciones.ResourceNotFoundException;
import com.proyecto.hotel.aplicacion.casosuso.entrada.ICatalogoServicioUseCase;
import com.proyecto.hotel.dominio.entidades.CatalogoServicio;
import com.proyecto.hotel.dominio.repositorios.ICatalogoServicioRepositorio;


public class CatalogoServicioUseCaseImpl implements ICatalogoServicioUseCase {

    private final ICatalogoServicioRepositorio repositorio;

    public CatalogoServicioUseCaseImpl(ICatalogoServicioRepositorio repositorio) {
        super();
        this.repositorio = repositorio;
    }

    @Override
    public CatalogoServicio guardar(CatalogoServicio nuevoServicio) {
        boolean existe = listarTodos().stream().anyMatch(s -> s.getnombreServicio().equalsIgnoreCase(nuevoServicio.getnombreServicio()));
        if (existe) {
            throw new IllegalArgumentException("Ya existe un servicio registrado con ese nombre.");
        }
        return repositorio.guardar(nuevoServicio);
    }

    @Override
    public CatalogoServicio buscarPorId(int idServicio) {
        return repositorio.buscarPorId(idServicio)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio no encontrado en el catálogo"));
    }

    @Override
    public List<CatalogoServicio> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idServicio) {
        buscarPorId(idServicio);
        repositorio.eliminar(idServicio);
    }
    
    @Override
    public CatalogoServicio actualizar(int idHuesped, CatalogoServicio datosActualizados) {
    	CatalogoServicio catalogoExistente = buscarPorId(idHuesped);
        
        if (!catalogoExistente.getnombreServicio().equalsIgnoreCase(datosActualizados.getnombreServicio())) {
            boolean existe = listarTodos().stream().anyMatch(s -> s.getnombreServicio().equalsIgnoreCase(datosActualizados.getnombreServicio()));
            if (existe) {
                throw new IllegalArgumentException("Ya existe otro servicio registrado con ese nombre.");
            }
        }
        
        catalogoExistente.setnombreServicio(datosActualizados.getnombreServicio());
        catalogoExistente.setTarifa(datosActualizados.getTarifa());
        catalogoExistente.setDescripcion(datosActualizados.getDescripcion());
        return repositorio.guardar(catalogoExistente);
    }
}
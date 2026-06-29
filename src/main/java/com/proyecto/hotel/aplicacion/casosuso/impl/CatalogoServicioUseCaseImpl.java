package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
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
        return repositorio.guardar(nuevoServicio);
    }

    @Override
    public CatalogoServicio actualizar(int idServicio, CatalogoServicio servicioActualizado) {
        repositorio.buscarPorId(idServicio)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado en el catálogo"));
        
        servicioActualizado.setIdServicio(idServicio);
        return repositorio.guardar(servicioActualizado);
    }

    @Override
    public CatalogoServicio buscarPorId(int idServicio) {
        return repositorio.buscarPorId(idServicio)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado en el catálogo"));
    }

    @Override
    public List<CatalogoServicio> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idServicio) {
        if (!repositorio.buscarPorId(idServicio).isPresent()) {
            throw new RuntimeException("Servicio no encontrado en el catálogo");
        }
        repositorio.eliminar(idServicio);
    }
}
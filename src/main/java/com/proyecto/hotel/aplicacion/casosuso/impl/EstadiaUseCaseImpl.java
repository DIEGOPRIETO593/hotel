package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IEstadiaUseCase;
import com.proyecto.hotel.dominio.entidades.Estadia;
import com.proyecto.hotel.dominio.repositorios.IEstadiaRepositorio;

public class EstadiaUseCaseImpl implements IEstadiaUseCase {

    private final IEstadiaRepositorio repositorio;

    public EstadiaUseCaseImpl(IEstadiaRepositorio repositorio) {
        super();
        this.repositorio = repositorio;
    }

    @Override
    public Estadia guardar(Estadia nuevaEstadia) {
        return repositorio.guardar(nuevaEstadia);
    }

    @Override
    public Estadia buscarPorId(int idEstadia) {
        return repositorio.buscarPorId(idEstadia)
                .orElseThrow(() -> new RuntimeException("Estadía no encontrada"));
    }

    @Override
    public List<Estadia> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idEstadia) {
        repositorio.eliminar(idEstadia);
    }
}
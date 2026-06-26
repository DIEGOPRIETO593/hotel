package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IHuespedUseCase;
import com.proyecto.hotel.dominio.entidades.Huesped;
import com.proyecto.hotel.dominio.repositorios.IHuespedRepositorio;

public class HuespedUseCaseImpl implements IHuespedUseCase {

    private final IHuespedRepositorio repositorio;

    public HuespedUseCaseImpl(IHuespedRepositorio repositorio) {
        super();
        this.repositorio = repositorio;
    }

    @Override
    public Huesped guardar(Huesped nuevoHuesped) {
        return repositorio.guardar(nuevoHuesped);
    }

    @Override
    public Huesped buscarPorId(int idHuesped) {
        return repositorio.buscarPorId(idHuesped)
                .orElseThrow(() -> new RuntimeException("Huésped no encontrado"));
    }

    @Override
    public List<Huesped> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idHuesped) {
        repositorio.eliminar(idHuesped);
    }
}
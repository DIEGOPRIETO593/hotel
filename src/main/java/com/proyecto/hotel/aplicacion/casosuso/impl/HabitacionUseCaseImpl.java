package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IHabitacionUseCase;
import com.proyecto.hotel.dominio.entidades.Habitacion;
import com.proyecto.hotel.dominio.repositorios.IHabitacionRepositorio;

public class HabitacionUseCaseImpl implements IHabitacionUseCase {

    private final IHabitacionRepositorio repositorio;

    public HabitacionUseCaseImpl(IHabitacionRepositorio repositorio) {
        super();
        this.repositorio = repositorio;
    }

    @Override
    public Habitacion guardar(Habitacion nuevaHabitacion) {
        return repositorio.guardar(nuevaHabitacion);
    }

    @Override
    public Habitacion buscarPorId(int idHabitacion) {
        return repositorio.buscarPorId(idHabitacion)
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));
    }

    @Override
    public List<Habitacion> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idHabitacion) {
        repositorio.eliminar(idHabitacion);
    }
}
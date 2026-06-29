package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IEstadiaUseCase;
import com.proyecto.hotel.dominio.entidades.Estadia;
import com.proyecto.hotel.dominio.entidades.Habitacion;
import com.proyecto.hotel.dominio.repositorios.IEstadiaRepositorio;
import com.proyecto.hotel.dominio.repositorios.IHabitacionRepositorio;

public class EstadiaUseCaseImpl implements IEstadiaUseCase {

    private final IEstadiaRepositorio repositorio;
    private final IHabitacionRepositorio habitacionRepositorio;

    public EstadiaUseCaseImpl(IEstadiaRepositorio repositorio, IHabitacionRepositorio habitacionRepositorio) {
        super();
        this.repositorio = repositorio;
        this.habitacionRepositorio = habitacionRepositorio;
    }

    @Override
    public Estadia guardar(Estadia nuevaEstadia) {
        Habitacion habitacion = habitacionRepositorio.buscarPorId(nuevaEstadia.getIdHabitacion())
                .orElseThrow(() -> new RuntimeException("La habitación con ID " + nuevaEstadia.getIdHabitacion() + " no existe."));

        if ("OCUPADA".equalsIgnoreCase(habitacion.getEstado()) || 
            "EN MANTENIMIENTO".equalsIgnoreCase(habitacion.getEstado())) {
            throw new RuntimeException("No se puede registrar la estadía. La habitación se encuentra " + habitacion.getEstado());
        }

        return repositorio.guardar(nuevaEstadia);
    }

    @Override
    public Estadia actualizar(int idEstadia, Estadia estadiaActualizada) {
        // 1. Verificamos que la estadía exista
        repositorio.buscarPorId(idEstadia)
                .orElseThrow(() -> new RuntimeException("Estadía no encontrada"));

        // 2. Verificamos que la nueva habitación asignada exista (en caso de que hayan cambiado de habitación)
        Habitacion habitacion = habitacionRepositorio.buscarPorId(estadiaActualizada.getIdHabitacion())
                .orElseThrow(() -> new RuntimeException("La habitación con ID " + estadiaActualizada.getIdHabitacion() + " no existe."));

        // 3. Mantenemos el ID original para que JPA realice un UPDATE
        estadiaActualizada.setIdEstadia(idEstadia);
        return repositorio.guardar(estadiaActualizada);
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
        if (!repositorio.buscarPorId(idEstadia).isPresent()) {
            throw new RuntimeException("Estadía no encontrada");
        }
        repositorio.eliminar(idEstadia);
    }
}


package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IEstadiaUseCase;
import com.proyecto.hotel.dominio.entidades.Estadia;
import com.proyecto.hotel.dominio.entidades.Habitacion;
import com.proyecto.hotel.dominio.entidades.Huesped;
import com.proyecto.hotel.dominio.repositorios.IEstadiaRepositorio;
import com.proyecto.hotel.dominio.repositorios.IHabitacionRepositorio;
import com.proyecto.hotel.dominio.repositorios.IHuespedRepositorio;

public class EstadiaUseCaseImpl implements IEstadiaUseCase {

    private final IEstadiaRepositorio repositorio;
    private final IHuespedRepositorio huespedRepositorio;
    private final IHabitacionRepositorio habitacionRepository;


    public EstadiaUseCaseImpl(IEstadiaRepositorio repositorio, 
                              IHuespedRepositorio huespedRepositorio, 
                              IHabitacionRepositorio habitacionRepository) {
        this.repositorio = repositorio;
        this.huespedRepositorio = huespedRepositorio;
        this.habitacionRepository = habitacionRepository;
    }

    @Override
    public Estadia guardar(Estadia nuevaEstadia) {
        Huesped huespedReal = huespedRepositorio.buscarPorId(nuevaEstadia.getHuesped().getidHuesped())
                .orElseThrow(() -> new RuntimeException("El huésped especificado no existe"));

        Habitacion habitacionReal = habitacionRepository.buscarPorId(nuevaEstadia.getHabitacion().getIdhabitacion())
                .orElseThrow(() -> new RuntimeException("La habitación especificada no existe"));

        nuevaEstadia.setHuesped(huespedReal);
        nuevaEstadia.setHabitacion(habitacionReal);
        

        
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
    
    @Override
    public Estadia actualizar(int idEstadia, Estadia datosActualizados) {
    	Estadia estadiaExistente = buscarPorId(idEstadia);
        estadiaExistente.setCantidadHuespedes(datosActualizados.getCantidadHuespedes());
        estadiaExistente.setFechaIngreso(datosActualizados.getFechaIngreso());
        estadiaExistente.setHabitacion(datosActualizados.getHabitacion());
        estadiaExistente.setFechaSalida(datosActualizados.getFechaSalida());
        estadiaExistente.setHabitacion(datosActualizados.getHabitacion());
        estadiaExistente.setHuesped(datosActualizados.getHuesped());
        estadiaExistente.setIdEstadia(datosActualizados.getIdEstadia());
        estadiaExistente.setTotalPagar(datosActualizados.getTotalPagar());
        
        return repositorio.guardar(estadiaExistente);
    }
}
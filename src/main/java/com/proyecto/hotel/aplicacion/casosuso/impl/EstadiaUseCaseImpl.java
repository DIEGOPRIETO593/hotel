package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import java.time.temporal.ChronoUnit;
import com.proyecto.hotel.aplicacion.excepciones.ResourceNotFoundException;
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
                .orElseThrow(() -> new ResourceNotFoundException("El huésped especificado no existe"));

        Habitacion habitacionReal = habitacionRepository.buscarPorId(nuevaEstadia.getHabitacion().getIdhabitacion())
                .orElseThrow(() -> new ResourceNotFoundException("La habitación especificada no existe"));

        boolean habitacionOcupada = listarTodos().stream()
                .anyMatch(e -> e.getHabitacion().getIdhabitacion() == habitacionReal.getIdhabitacion());
        
        if (habitacionOcupada) {
            throw new IllegalArgumentException("La habitación especificada ya se encuentra ocupada por otro huésped.");
        }

        nuevaEstadia.setHuesped(huespedReal);
        nuevaEstadia.setHabitacion(habitacionReal);
        
        long dias = ChronoUnit.DAYS.between(nuevaEstadia.getFechaIngreso(), nuevaEstadia.getFechaSalida());
        if (dias < 1) dias = 1;
        if (habitacionReal.getPrecio() != null) {
            nuevaEstadia.setTotalPagar(dias * habitacionReal.getPrecio());
        } else {
            nuevaEstadia.setTotalPagar(0.0);
        }
        
        return repositorio.guardar(nuevaEstadia);
    }

    @Override
    public Estadia buscarPorId(int idEstadia) {
        return repositorio.buscarPorId(idEstadia)
                .orElseThrow(() -> new ResourceNotFoundException("Estadía no encontrada"));
    }

    @Override
    public List<Estadia> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idEstadia) {
        buscarPorId(idEstadia);

        repositorio.eliminar(idEstadia);
    }
    
    @Override
    public Estadia actualizar(int idEstadia, Estadia datosActualizados) {
    	Estadia estadiaExistente = buscarPorId(idEstadia);
        
        if (datosActualizados.getHuesped() != null && datosActualizados.getHuesped().getidHuesped() > 0) {
            Huesped huespedReal = huespedRepositorio.buscarPorId(datosActualizados.getHuesped().getidHuesped())
                .orElseThrow(() -> new ResourceNotFoundException("El huésped especificado no existe"));
            estadiaExistente.setHuesped(huespedReal);
        }

        if (datosActualizados.getHabitacion() != null && datosActualizados.getHabitacion().getIdhabitacion() > 0) {
            Habitacion habitacionReal = habitacionRepository.buscarPorId(datosActualizados.getHabitacion().getIdhabitacion())
                .orElseThrow(() -> new ResourceNotFoundException("La habitación especificada no existe"));
            
            if (habitacionReal.getIdhabitacion() != estadiaExistente.getHabitacion().getIdhabitacion()) {
                boolean habitacionOcupada = listarTodos().stream()
                    .anyMatch(e -> e.getHabitacion().getIdhabitacion() == habitacionReal.getIdhabitacion());
                
                if (habitacionOcupada) {
                    throw new IllegalArgumentException("La nueva habitación especificada ya se encuentra ocupada por otro huésped.");
                }
            }
            
            estadiaExistente.setHabitacion(habitacionReal);
        }
        
        estadiaExistente.setCantidadHuespedes(datosActualizados.getCantidadHuespedes());
        estadiaExistente.setFechaIngreso(datosActualizados.getFechaIngreso());
        estadiaExistente.setFechaSalida(datosActualizados.getFechaSalida());
        
        long dias = ChronoUnit.DAYS.between(estadiaExistente.getFechaIngreso(), estadiaExistente.getFechaSalida());
        if (dias < 1) dias = 1;
        if (estadiaExistente.getHabitacion().getPrecio() != null) {
            estadiaExistente.setTotalPagar(dias * estadiaExistente.getHabitacion().getPrecio());
        } else {
            estadiaExistente.setTotalPagar(0.0);
        }
        
        return repositorio.guardar(estadiaExistente);
    }
}
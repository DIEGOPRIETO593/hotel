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

/**
 * Caso de uso: Implementación de la lógica de negocio para la gestión de Estadías.
 * Capa: Aplicación (Clean Architecture / Arquitectura Hexagonal).
 * Responsabilidad: Coordinar las operaciones entre las entidades Huesped, Habitacion y Estadia,
 * aplicando reglas de negocio estrictas como validación de ocupación y transiciones de estado automáticas.
 */
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
    /**
     * Registra una nueva estadía aplicando las siguientes reglas de negocio:
     * 1. Valida la existencia del Huésped y la Habitación en la base de datos.
     * 2. Verifica que la habitación no esté actualmente ocupada por otra estadía activa.
     * 3. Establece el estado por defecto 'Por Cobrar' si no se provee uno.
     * 4. Actualiza automáticamente el estado de la habitación ('Disponible' si es pagado, 'Ocupada' en caso contrario).
     * 5. Calcula automáticamente el total a pagar en función del número de días y la tarifa de la habitación.
     */
    public Estadia guardar(Estadia nuevaEstadia) {
        Huesped huespedReal = huespedRepositorio.buscarPorId(nuevaEstadia.getHuesped().getidHuesped())
                .orElseThrow(() -> new ResourceNotFoundException("El huésped especificado no existe"));

        Habitacion habitacionReal = habitacionRepository.buscarPorId(nuevaEstadia.getHabitacion().getIdhabitacion())
                .orElseThrow(() -> new ResourceNotFoundException("La habitación especificada no existe"));

        boolean habitacionOcupada = listarTodos().stream()
                .anyMatch(e -> e.getHabitacion().getIdhabitacion() == habitacionReal.getIdhabitacion() && !"Pagado".equalsIgnoreCase(e.getEstado()));
        
        if (habitacionOcupada) {
            throw new IllegalArgumentException("La habitación especificada ya se encuentra ocupada por otro huésped.");
        }

        nuevaEstadia.setHuesped(huespedReal);
        nuevaEstadia.setHabitacion(habitacionReal);
        
        if (nuevaEstadia.getEstado() == null || nuevaEstadia.getEstado().trim().isEmpty()) {
            nuevaEstadia.setEstado("Por Cobrar");
        }
        
        if ("Pagado".equalsIgnoreCase(nuevaEstadia.getEstado())) {
            habitacionReal.setEstado("Disponible");
            habitacionRepository.guardar(habitacionReal);
        } else {
            habitacionReal.setEstado("Ocupada");
            habitacionRepository.guardar(habitacionReal);
        }

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
    /**
     * Recupera y lista todas las estadías registradas en el sistema.
     */
    public List<Estadia> listarTodos() {
        List<Estadia> lista = repositorio.listarTodos();
        for (Estadia e : lista) {
            if (e.getEstado() == null || e.getEstado().trim().isEmpty()) {
                e.setEstado("Por Cobrar");
            }
        }
        return lista;
    }

    @Override
    public void eliminar(int idEstadia) {
        Estadia estadia = buscarPorId(idEstadia);
        if (estadia.getHabitacion() != null && !"Pagado".equalsIgnoreCase(estadia.getEstado())) {
            estadia.getHabitacion().setEstado("Disponible");
            habitacionRepository.guardar(estadia.getHabitacion());
        }
        repositorio.eliminar(idEstadia);
    }
    
    @Override
    public Estadia actualizar(int idEstadia, Estadia datosActualizados) {
    	Estadia estadiaExistente = buscarPorId(idEstadia);
        Habitacion habitacionAntigua = estadiaExistente.getHabitacion();
        
        if (datosActualizados.getHuesped() != null && datosActualizados.getHuesped().getidHuesped() > 0) {
            Huesped huespedReal = huespedRepositorio.buscarPorId(datosActualizados.getHuesped().getidHuesped())
                .orElseThrow(() -> new ResourceNotFoundException("El huésped especificado no existe"));
            estadiaExistente.setHuesped(huespedReal);
        }

        if (datosActualizados.getHabitacion() != null && datosActualizados.getHabitacion().getIdhabitacion() > 0) {
            Habitacion habitacionReal = habitacionRepository.buscarPorId(datosActualizados.getHabitacion().getIdhabitacion())
                .orElseThrow(() -> new ResourceNotFoundException("La habitación especificada no existe"));
            
            if (habitacionReal.getIdhabitacion() != habitacionAntigua.getIdhabitacion()) {
                boolean habitacionOcupada = listarTodos().stream()
                    .anyMatch(e -> e.getIdEstadia() != idEstadia && e.getHabitacion().getIdhabitacion() == habitacionReal.getIdhabitacion() && !"Pagado".equalsIgnoreCase(e.getEstado()));
                
                if (habitacionOcupada) {
                    throw new IllegalArgumentException("La nueva habitación especificada ya se encuentra ocupada por otro huésped.");
                }
                if (!"Pagado".equalsIgnoreCase(estadiaExistente.getEstado())) {
                    habitacionAntigua.setEstado("Disponible");
                    habitacionRepository.guardar(habitacionAntigua);
                }
            }
            
            estadiaExistente.setHabitacion(habitacionReal);
        }
        
        if (datosActualizados.getEstado() != null && !datosActualizados.getEstado().trim().isEmpty()) {
            estadiaExistente.setEstado(datosActualizados.getEstado());
        } else if (estadiaExistente.getEstado() == null) {
            estadiaExistente.setEstado("Por Cobrar");
        }
        
        if ("Pagado".equalsIgnoreCase(estadiaExistente.getEstado())) {
            estadiaExistente.getHabitacion().setEstado("Disponible");
            habitacionRepository.guardar(estadiaExistente.getHabitacion());
        } else {
            estadiaExistente.getHabitacion().setEstado("Ocupada");
            habitacionRepository.guardar(estadiaExistente.getHabitacion());
        }

        estadiaExistente.setCantidadHuespedes(datosActualizados.getCantidadHuespedes());
        estadiaExistente.setFechaIngreso(datosActualizados.getFechaIngreso());
        estadiaExistente.setFechaSalida(datosActualizados.getFechaSalida());
        estadiaExistente.setObservaciones(datosActualizados.getObservaciones());
        
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
package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.excepciones.ResourceNotFoundException;
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
                .orElseThrow(() -> new ResourceNotFoundException("Huésped no encontrado"));
    }

    @Override
    public List<Huesped> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idHuesped) {
        buscarPorId(idHuesped);

        repositorio.eliminar(idHuesped);
    }
    @Override
    public Huesped actualizar(int idHuesped, Huesped datosActualizados) {
        Huesped huespedExistente = buscarPorId(idHuesped);
        
        if (datosActualizados.getCedula() != null && !datosActualizados.getCedula().equals(huespedExistente.getCedula())) {
            throw new IllegalArgumentException("La cédula no se puede modificar una vez registrada.");
        }
        
        huespedExistente.setNombre(datosActualizados.getNombre());
        huespedExistente.setApellido(datosActualizados.getApellido());
        huespedExistente.setTelefono(datosActualizados.getTelefono());
        return repositorio.guardar(huespedExistente);
    }
}
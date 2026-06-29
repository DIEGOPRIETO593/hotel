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
        // Validación de regla de negocio: La cédula debe ser única en el sistema
        if (repositorio.buscarPorCedula(nuevoHuesped.getCedula()).isPresent()) {
            throw new RuntimeException("Ya existe un huésped registrado con la cédula: " + nuevoHuesped.getCedula());
        }
        return repositorio.guardar(nuevoHuesped);
    }

    @Override
    public Huesped actualizar(int idHuesped, Huesped huespedActualizado) {
        // 1. Verificamos que el huésped a editar realmente exista
        Huesped huespedExistente = repositorio.buscarPorId(idHuesped)
                .orElseThrow(() -> new RuntimeException("Huésped no encontrado"));
        
        // 2. Si se está intentando cambiar la cédula, debemos asegurar que la nueva cédula esté libre
        if (!huespedExistente.getCedula().equals(huespedActualizado.getCedula())) {
            if (repositorio.buscarPorCedula(huespedActualizado.getCedula()).isPresent()) {
                throw new RuntimeException("Ya existe un huésped registrado con la cédula: " + huespedActualizado.getCedula());
            }
        }
        
        // 3. Conservamos el ID original para que la base de datos sepa que es una actualización (UPDATE) y no una creación (INSERT)
        huespedActualizado.setIdHuesped(idHuesped);
        return repositorio.guardar(huespedActualizado);
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
        if (!repositorio.buscarPorId(idHuesped).isPresent()) {
            throw new RuntimeException("Huésped no encontrado");
        }
        repositorio.eliminar(idHuesped);
    }
}
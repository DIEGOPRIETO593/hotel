package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IMinibarUseCase;
import com.proyecto.hotel.dominio.entidades.Minibar;
import com.proyecto.hotel.dominio.repositorios.IMinibarRepositorio;

public class MinibarUseCaseImpl implements IMinibarUseCase {

    private final IMinibarRepositorio repositorio;

    public MinibarUseCaseImpl(IMinibarRepositorio repositorio) {
        super();
        this.repositorio = repositorio;
    }

    @Override
    public Minibar guardar(Minibar nuevoMinibar) {
        return repositorio.guardar(nuevoMinibar);
    }

    @Override
    public Minibar buscarPorId(int idMinibar) {
        return repositorio.buscarPorId(idMinibar)
                .orElseThrow(() -> new RuntimeException("Minibar no encontrado con el ID: " + idMinibar));
    }

    @Override
    public List<Minibar> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idMinibar) {
        repositorio.eliminar(idMinibar);
    }

    @Override
    public Minibar actualizar(int idMinibar, Minibar datosActualizados) {
        Minibar minibarExistente = buscarPorId(idMinibar);
        
        minibarExistente.setHabitacion(datosActualizados.getHabitacion());
        minibarExistente.setProducto(datosActualizados.getProducto());
        minibarExistente.setCantidad(datosActualizados.getCantidad());
        
        return repositorio.guardar(minibarExistente);
    }
}
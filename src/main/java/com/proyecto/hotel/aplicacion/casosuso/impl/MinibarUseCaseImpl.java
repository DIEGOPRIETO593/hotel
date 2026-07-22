package com.proyecto.hotel.aplicacion.casosuso.impl;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IMinibarUseCase;
import com.proyecto.hotel.dominio.entidades.Minibar;
import com.proyecto.hotel.dominio.repositorios.IMinibarRepositorio;
import java.util.List;
public class MinibarUseCaseImpl implements IMinibarUseCase {
    private final IMinibarRepositorio repositorio;
    public MinibarUseCaseImpl(IMinibarRepositorio repositorio) { this.repositorio = repositorio; }
    @Override public Minibar guardar(Minibar minibar) { return repositorio.guardar(minibar); }
    @Override public List<Minibar> listarTodos() { return repositorio.listarTodos(); }
    @Override public Minibar buscarPorId(int id) { return repositorio.buscarPorId(id); }
    @Override public void eliminar(int id) { repositorio.eliminar(id); }
}

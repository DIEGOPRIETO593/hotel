package com.proyecto.hotel.aplicacion.casosuso.impl;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IProductoUseCase;
import com.proyecto.hotel.dominio.entidades.Producto;
import com.proyecto.hotel.dominio.repositorios.IProductoRepositorio;
import java.util.List;
public class ProductoUseCaseImpl implements IProductoUseCase {
    private final IProductoRepositorio repositorio;
    public ProductoUseCaseImpl(IProductoRepositorio repositorio) { this.repositorio = repositorio; }
    @Override public Producto guardar(Producto producto) { return repositorio.guardar(producto); }
    @Override public List<Producto> listarTodos() { return repositorio.listarTodos(); }
    @Override public Producto buscarPorId(int id) { return repositorio.buscarPorId(id); }
    @Override public void eliminar(int id) { repositorio.eliminar(id); }
}

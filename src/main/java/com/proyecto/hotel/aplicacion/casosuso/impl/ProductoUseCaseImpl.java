package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IProductoUseCase;
import com.proyecto.hotel.dominio.entidades.Producto;
import com.proyecto.hotel.dominio.repositorios.IProductoRepositorio;

public class ProductoUseCaseImpl implements IProductoUseCase {

    private final IProductoRepositorio repositorio;

    public ProductoUseCaseImpl(IProductoRepositorio repositorio) {
        super();
        this.repositorio = repositorio;
    }

    @Override
    public Producto guardar(Producto nuevoProducto) {
        return repositorio.guardar(nuevoProducto);
    }

    @Override
    public Producto buscarPorId(int idProducto) {
        return repositorio.buscarPorId(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con el ID: " + idProducto));
    }

    @Override
    public List<Producto> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idProducto) {
        repositorio.eliminar(idProducto);
    }

    @Override
    public Producto actualizar(int idProducto, Producto datosActualizados) {
        Producto productoExistente = buscarPorId(idProducto);
        
        productoExistente.setNombre(datosActualizados.getNombre());
        productoExistente.setPrecio(datosActualizados.getPrecio());
        productoExistente.setCantidad(datosActualizados.getCantidad());
        productoExistente.setStock(datosActualizados.getStock());
        
        return repositorio.guardar(productoExistente);
    }
}
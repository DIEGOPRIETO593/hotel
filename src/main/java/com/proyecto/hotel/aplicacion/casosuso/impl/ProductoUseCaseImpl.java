package com.proyecto.hotel.aplicacion.casosuso.impl;

import java.util.List;
import com.proyecto.hotel.aplicacion.excepciones.ResourceNotFoundException;
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
        boolean existe = listarTodos().stream().anyMatch(p -> p.getNombre().equalsIgnoreCase(nuevoProducto.getNombre()));
        if (existe) {
            throw new IllegalArgumentException("Ya existe un producto registrado con ese nombre.");
        }
        return repositorio.guardar(nuevoProducto);
    }

    @Override
    public Producto buscarPorId(int idProducto) {
        return repositorio.buscarPorId(idProducto)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con el ID: " + idProducto));
    }

    @Override
    public List<Producto> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public void eliminar(int idProducto) {
        buscarPorId(idProducto);
        repositorio.eliminar(idProducto);
    }

    @Override
    public Producto actualizar(int idProducto, Producto datosActualizados) {
        Producto productoExistente = buscarPorId(idProducto);
        
        if (!productoExistente.getNombre().equalsIgnoreCase(datosActualizados.getNombre())) {
            boolean existe = listarTodos().stream().anyMatch(p -> p.getNombre().equalsIgnoreCase(datosActualizados.getNombre()));
            if (existe) {
                throw new IllegalArgumentException("Ya existe otro producto registrado con ese nombre.");
            }
        }
        
        productoExistente.setNombre(datosActualizados.getNombre());
        productoExistente.setPrecio(datosActualizados.getPrecio());
        productoExistente.setCantidad(datosActualizados.getCantidad());
        productoExistente.setStock(datosActualizados.getStock());
        
        return repositorio.guardar(productoExistente);
    }
}
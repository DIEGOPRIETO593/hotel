package com.proyecto.hotel.aplicacion.casosuso.entrada;

import java.util.List;
import com.proyecto.hotel.dominio.entidades.Producto;

public interface IProductoUseCase {
    Producto guardar(Producto nuevoProducto);
    Producto actualizar(int idProducto, Producto datosActualizados);
    Producto buscarPorId(int idProducto);
    List<Producto> listarTodos();
    void eliminar(int idProducto);
}
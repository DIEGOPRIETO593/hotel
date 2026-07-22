package com.proyecto.hotel.dominio.repositorios;
import com.proyecto.hotel.dominio.entidades.Producto;
import java.util.List;
public interface IProductoRepositorio {
    Producto guardar(Producto producto);
    List<Producto> listarTodos();
    Producto buscarPorId(int id);
    void eliminar(int id);
}

package com.proyecto.hotel.aplicacion.casosuso.entrada;
import com.proyecto.hotel.dominio.entidades.Producto;
import java.util.List;
public interface IProductoUseCase {
    Producto guardar(Producto producto);
    List<Producto> listarTodos();
    Producto buscarPorId(int id);
    void eliminar(int id);
}

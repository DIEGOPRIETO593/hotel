package com.proyecto.hotel.dominio.repositorios;
import com.proyecto.hotel.dominio.entidades.Minibar;
import java.util.List;
public interface IMinibarRepositorio {
    Minibar guardar(Minibar minibar);
    List<Minibar> listarTodos();
    Minibar buscarPorId(int id);
    void eliminar(int id);
}

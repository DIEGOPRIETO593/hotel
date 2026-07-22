package com.proyecto.hotel.aplicacion.casosuso.entrada;
import com.proyecto.hotel.dominio.entidades.Minibar;
import java.util.List;
public interface IMinibarUseCase {
    Minibar guardar(Minibar minibar);
    List<Minibar> listarTodos();
    Minibar buscarPorId(int id);
    void eliminar(int id);
}

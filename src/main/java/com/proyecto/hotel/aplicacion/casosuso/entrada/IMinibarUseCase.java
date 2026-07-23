package com.proyecto.hotel.aplicacion.casosuso.entrada;

import java.util.List;
import com.proyecto.hotel.dominio.entidades.Minibar;

public interface IMinibarUseCase {
    Minibar guardar(Minibar nuevoMinibar);
    Minibar actualizar(int idMinibar, Minibar datosActualizados);
    Minibar buscarPorId(int idMinibar);
    List<Minibar> listarTodos();
    void eliminar(int idMinibar);
}
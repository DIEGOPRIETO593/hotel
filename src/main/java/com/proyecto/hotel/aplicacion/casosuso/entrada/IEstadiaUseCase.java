package com.proyecto.hotel.aplicacion.casosuso.entrada;

import java.util.List;
import com.proyecto.hotel.dominio.entidades.Estadia;

public interface IEstadiaUseCase {
    Estadia guardar(Estadia nuevaEstadia);
    Estadia buscarPorId(int idEstadia);
    List<Estadia> listarTodos();
    void eliminar(int idEstadia);
}
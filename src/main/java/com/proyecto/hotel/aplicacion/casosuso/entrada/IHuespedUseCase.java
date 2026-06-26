package com.proyecto.hotel.aplicacion.casosuso.entrada;

import java.util.List;
import com.proyecto.hotel.dominio.entidades.Huesped;

public interface IHuespedUseCase {
    Huesped guardar(Huesped nuevoHuesped);
    Huesped buscarPorId(int idHuesped);
    List<Huesped> listarTodos();
    void eliminar(int idHuesped);
}
package com.proyecto.hotel.aplicacion.casosuso.entrada;

import java.util.List;
import com.proyecto.hotel.dominio.entidades.CatalogoServicio;

public interface ICatalogoServicioUseCase {
    CatalogoServicio guardar(CatalogoServicio nuevoServicio);
    CatalogoServicio actualizar(int idServicio, CatalogoServicio datosActualizados);
    CatalogoServicio buscarPorId(int idServicio);
    List<CatalogoServicio> listarTodos();
    void eliminar(int idServicio);
}

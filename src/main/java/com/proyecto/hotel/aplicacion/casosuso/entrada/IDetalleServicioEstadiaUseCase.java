package com.proyecto.hotel.aplicacion.casosuso.entrada;

import java.util.List;
import com.proyecto.hotel.dominio.entidades.DetalleServicioEstadia;

public interface IDetalleServicioEstadiaUseCase {
    DetalleServicioEstadia guardar(DetalleServicioEstadia nuevoDetalle);
    DetalleServicioEstadia buscarPorId(int idDetalle);
    List<DetalleServicioEstadia> listarTodos();
    void eliminar(int idDetalle);
}
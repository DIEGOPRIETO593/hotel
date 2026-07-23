package com.proyecto.hotel.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.proyecto.hotel.dominio.entidades.Minibar;
import com.proyecto.hotel.dominio.repositorios.IMinibarRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.jpa.HabitacionEntity;
import com.proyecto.hotel.infraestructura.persistencia.jpa.MinibarEntity;
import com.proyecto.hotel.infraestructura.persistencia.jpa.ProductoEntity;
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.IMinibarJpaMapper;
import com.proyecto.hotel.infraestructura.repositorios.IHabitacionJpaRepositorio;
import com.proyecto.hotel.infraestructura.repositorios.IMinibarJpaRepositorio;
import com.proyecto.hotel.infraestructura.repositorios.IProductoJpaRepositorio;

public class MinibarRepositorioImpl implements IMinibarRepositorio {

    private final IMinibarJpaRepositorio jpaRepositorio;
    private final IHabitacionJpaRepositorio habitacionJpaRepositorio;
    private final IProductoJpaRepositorio productoJpaRepositorio;
    private final IMinibarJpaMapper entityMapper;

    public MinibarRepositorioImpl(
            IMinibarJpaRepositorio jpaRepositorio,
            IHabitacionJpaRepositorio habitacionJpaRepositorio,
            IProductoJpaRepositorio productoJpaRepositorio,
            IMinibarJpaMapper entityMapper) {
        this.jpaRepositorio = jpaRepositorio;
        this.habitacionJpaRepositorio = habitacionJpaRepositorio;
        this.productoJpaRepositorio = productoJpaRepositorio;
        this.entityMapper = entityMapper;
    }

    @Override
    public Minibar guardar(Minibar nuevoMinibar) {
        MinibarEntity entity = entityMapper.toEntity(nuevoMinibar);
        MinibarEntity guardado = jpaRepositorio.save(entity);
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<Minibar> buscarPorId(int idMinibar) {
        return jpaRepositorio.findById(idMinibar).map(entityMapper::toDomain);
    }

    @Override
    public List<Minibar> listarTodos() {
        return jpaRepositorio.findAll().stream()
                .map(entityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(int idMinibar) {
        jpaRepositorio.deleteById(idMinibar);
    }

    @Override
    public Optional<Minibar> buscarPorCedula(String cedula) {
        return Optional.empty();
    }
}
package com.proyecto.hotel.infraestructura.persistencia.adaptadores;
import com.proyecto.hotel.dominio.entidades.Minibar;
import com.proyecto.hotel.dominio.repositorios.IMinibarRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.jpa.MinibarEntity;
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.IMinibarJpaMapper;
import com.proyecto.hotel.infraestructura.repositorios.IMinibarJpaRepositorio;
import com.proyecto.hotel.infraestructura.repositorios.IHabitacionJpaRepositorio;
import com.proyecto.hotel.infraestructura.repositorios.IProductoJpaRepositorio;
import java.util.List;
import java.util.stream.Collectors;
public class MinibarRepositorioImpl implements IMinibarRepositorio {
    private final IMinibarJpaRepositorio jpaRepositorio;
    private final IMinibarJpaMapper mapper;
    private final IHabitacionJpaRepositorio habitacionJpa;
    private final IProductoJpaRepositorio productoJpa;
    public MinibarRepositorioImpl(IMinibarJpaRepositorio jpaRepositorio, IMinibarJpaMapper mapper, IHabitacionJpaRepositorio habitacionJpa, IProductoJpaRepositorio productoJpa) {
        this.jpaRepositorio = jpaRepositorio;
        this.mapper = mapper;
        this.habitacionJpa = habitacionJpa;
        this.productoJpa = productoJpa;
    }
    @Override public Minibar guardar(Minibar minibar) {
        MinibarEntity entity = mapper.toEntity(minibar);
        entity.setHabitacion(habitacionJpa.findById(minibar.getId_habitacion()).orElse(null));
        entity.setProducto(productoJpa.findById(minibar.getId_producto()).orElse(null));
        return mapper.toDomain(jpaRepositorio.save(entity));
    }
    @Override public List<Minibar> listarTodos() {
        return jpaRepositorio.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }
    @Override public Minibar buscarPorId(int id) {
        return jpaRepositorio.findById(id).map(mapper::toDomain).orElse(null);
    }
    @Override public void eliminar(int id) {
        jpaRepositorio.deleteById(id);
    }
}

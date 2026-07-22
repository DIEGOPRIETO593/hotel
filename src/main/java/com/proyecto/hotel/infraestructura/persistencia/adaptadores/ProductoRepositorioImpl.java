package com.proyecto.hotel.infraestructura.persistencia.adaptadores;
import com.proyecto.hotel.dominio.entidades.Producto;
import com.proyecto.hotel.dominio.repositorios.IProductoRepositorio;
import com.proyecto.hotel.infraestructura.persistencia.jpa.ProductoEntity;
import com.proyecto.hotel.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.proyecto.hotel.infraestructura.repositorios.IProductoJpaRepositorio;
import java.util.List;
import java.util.stream.Collectors;
public class ProductoRepositorioImpl implements IProductoRepositorio {
    private final IProductoJpaRepositorio jpaRepositorio;
    private final IProductoJpaMapper mapper;
    public ProductoRepositorioImpl(IProductoJpaRepositorio jpaRepositorio, IProductoJpaMapper mapper) {
        this.jpaRepositorio = jpaRepositorio;
        this.mapper = mapper;
    }
    @Override public Producto guardar(Producto producto) {
        ProductoEntity entity = mapper.toEntity(producto);
        return mapper.toDomain(jpaRepositorio.save(entity));
    }
    @Override public List<Producto> listarTodos() {
        return jpaRepositorio.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }
    @Override public Producto buscarPorId(int id) {
        return jpaRepositorio.findById(id).map(mapper::toDomain).orElse(null);
    }
    @Override public void eliminar(int id) {
        jpaRepositorio.deleteById(id);
    }
}

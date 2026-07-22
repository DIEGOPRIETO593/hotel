import os

base_pkg = 'com.proyecto.hotel'
base_dir = r'C:\Universida Israel\6to Semestre\Desarrollo de software\Code\hotel-master\src\main\java\com\proyecto\hotel'

files = {
    # ------------------ PRODUCTO ------------------
    'dominio/entidades/Producto.java': '''package {pkg}.dominio.entidades;
public class Producto {{
    private int id_producto;
    private String nombre;
    private double precio;
    private int stock;
    public Producto() {{}}
    public Producto(int id_producto, String nombre, double precio, int stock) {{
        this.id_producto = id_producto; this.nombre = nombre; this.precio = precio; this.stock = stock;
    }}
    public int getId_producto() {{ return id_producto; }}
    public void setId_producto(int id_producto) {{ this.id_producto = id_producto; }}
    public String getNombre() {{ return nombre; }}
    public void setNombre(String nombre) {{ this.nombre = nombre; }}
    public double getPrecio() {{ return precio; }}
    public void setPrecio(double precio) {{ this.precio = precio; }}
    public int getStock() {{ return stock; }}
    public void setStock(int stock) {{ this.stock = stock; }}
}}
'''.replace('{pkg}', base_pkg),

    'dominio/repositorios/IProductoRepositorio.java': '''package {pkg}.dominio.repositorios;
import {pkg}.dominio.entidades.Producto;
import java.util.List;
public interface IProductoRepositorio {
    Producto guardar(Producto producto);
    List<Producto> listarTodos();
    Producto buscarPorId(int id);
    void eliminar(int id);
}
'''.replace('{pkg}', base_pkg),

    'aplicacion/casosuso/entrada/IProductoUseCase.java': '''package {pkg}.aplicacion.casosuso.entrada;
import {pkg}.dominio.entidades.Producto;
import java.util.List;
public interface IProductoUseCase {
    Producto guardar(Producto producto);
    List<Producto> listarTodos();
    Producto buscarPorId(int id);
    void eliminar(int id);
}
'''.replace('{pkg}', base_pkg),

    'aplicacion/casosuso/impl/ProductoUseCaseImpl.java': '''package {pkg}.aplicacion.casosuso.impl;
import {pkg}.aplicacion.casosuso.entrada.IProductoUseCase;
import {pkg}.dominio.entidades.Producto;
import {pkg}.dominio.repositorios.IProductoRepositorio;
import java.util.List;
public class ProductoUseCaseImpl implements IProductoUseCase {
    private final IProductoRepositorio repositorio;
    public ProductoUseCaseImpl(IProductoRepositorio repositorio) { this.repositorio = repositorio; }
    @Override public Producto guardar(Producto producto) { return repositorio.guardar(producto); }
    @Override public List<Producto> listarTodos() { return repositorio.listarTodos(); }
    @Override public Producto buscarPorId(int id) { return repositorio.buscarPorId(id); }
    @Override public void eliminar(int id) { repositorio.eliminar(id); }
}
'''.replace('{pkg}', base_pkg),

    'infraestructura/persistencia/jpa/ProductoEntity.java': '''package {pkg}.infraestructura.persistencia.jpa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "producto")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;
    @Column(name = "nombre", length = 100)
    private String nombre;
    @Column(name = "precio")
    private double precio;
    @Column(name = "stock")
    private int stock;
}
'''.replace('{pkg}', base_pkg),

    'infraestructura/repositorios/IProductoJpaRepositorio.java': '''package {pkg}.infraestructura.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import {pkg}.infraestructura.persistencia.jpa.ProductoEntity;
public interface IProductoJpaRepositorio extends JpaRepository<ProductoEntity, Integer> {
}
'''.replace('{pkg}', base_pkg),

    'infraestructura/persistencia/mapeadores/IProductoJpaMapper.java': '''package {pkg}.infraestructura.persistencia.mapeadores;
import org.mapstruct.Mapper;
import {pkg}.dominio.entidades.Producto;
import {pkg}.infraestructura.persistencia.jpa.ProductoEntity;
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IProductoJpaMapper {
    Producto toDomain(ProductoEntity entity);
    ProductoEntity toEntity(Producto domain);
}
'''.replace('{pkg}', base_pkg),

    'infraestructura/persistencia/adaptadores/ProductoRepositorioImpl.java': '''package {pkg}.infraestructura.persistencia.adaptadores;
import {pkg}.dominio.entidades.Producto;
import {pkg}.dominio.repositorios.IProductoRepositorio;
import {pkg}.infraestructura.persistencia.jpa.ProductoEntity;
import {pkg}.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import {pkg}.infraestructura.repositorios.IProductoJpaRepositorio;
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
'''.replace('{pkg}', base_pkg),

    'presentacion/dto/request/ProductoRequestDTO.java': '''package {pkg}.presentacion.dto.request;
import lombok.Data;
@Data
public class ProductoRequestDTO {
    private int idProducto;
    private String nombre;
    private double precio;
    private int stock;
}
'''.replace('{pkg}', base_pkg),

    'presentacion/dto/response/ProductoResponseDTO.java': '''package {pkg}.presentacion.dto.response;
import lombok.Data;
@Data
public class ProductoResponseDTO {
    private Long idProducto;
    private String nombre;
    private Double precio;
    private Integer stock;
}
'''.replace('{pkg}', base_pkg),

    'presentacion/mapeadores/IProductoDtoMapper.java': '''package {pkg}.presentacion.mapeadores;
import org.mapstruct.Mapper;
import {pkg}.dominio.entidades.Producto;
import {pkg}.presentacion.dto.request.ProductoRequestDTO;
import {pkg}.presentacion.dto.response.ProductoResponseDTO;
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IProductoDtoMapper {
    @org.mapstruct.Mapping(source = "idProducto", target = "id_producto")
    Producto toDomain(ProductoRequestDTO dto);
    
    @org.mapstruct.Mapping(source = "id_producto", target = "idProducto")
    ProductoResponseDTO toResponseDto(Producto entity);
}
'''.replace('{pkg}', base_pkg),

    'presentacion/controladores/ProductoController.java': '''package {pkg}.presentacion.controladores;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import {pkg}.aplicacion.casosuso.entrada.IProductoUseCase;
import {pkg}.dominio.entidades.Producto;
import {pkg}.presentacion.dto.request.ProductoRequestDTO;
import {pkg}.presentacion.dto.response.ProductoResponseDTO;
import {pkg}.presentacion.mapeadores.IProductoDtoMapper;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    private final IProductoUseCase useCase;
    private final IProductoDtoMapper mapper;
    public ProductoController(IProductoUseCase useCase, IProductoDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listarTodos() {
        List<ProductoResponseDTO> list = useCase.listarTodos().stream().map(mapper::toResponseDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> buscarPorId(@PathVariable int id) {
        Producto entity = useCase.buscarPorId(id);
        if (entity != null) return new ResponseEntity<>(mapper.toResponseDto(entity), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> guardar(@RequestBody ProductoRequestDTO request) {
        Producto entity = useCase.guardar(mapper.toDomain(request));
        return new ResponseEntity<>(mapper.toResponseDto(entity), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizar(@PathVariable int id, @RequestBody ProductoRequestDTO request) {
        request.setIdProducto(id);
        Producto entity = useCase.guardar(mapper.toDomain(request));
        return new ResponseEntity<>(mapper.toResponseDto(entity), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        useCase.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
'''.replace('{pkg}', base_pkg),


    # ------------------ MINIBAR ------------------
    'dominio/entidades/Minibar.java': '''package {pkg}.dominio.entidades;
public class Minibar {
    private int id_minibar;
    private int id_habitacion;
    private int id_producto;
    private int cantidad;
    public Minibar() {}
    public int getId_minibar() { return id_minibar; }
    public void setId_minibar(int id_minibar) { this.id_minibar = id_minibar; }
    public int getId_habitacion() { return id_habitacion; }
    public void setId_habitacion(int id_habitacion) { this.id_habitacion = id_habitacion; }
    public int getId_producto() { return id_producto; }
    public void setId_producto(int id_producto) { this.id_producto = id_producto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
'''.replace('{pkg}', base_pkg),

    'dominio/repositorios/IMinibarRepositorio.java': '''package {pkg}.dominio.repositorios;
import {pkg}.dominio.entidades.Minibar;
import java.util.List;
public interface IMinibarRepositorio {
    Minibar guardar(Minibar minibar);
    List<Minibar> listarTodos();
    Minibar buscarPorId(int id);
    void eliminar(int id);
}
'''.replace('{pkg}', base_pkg),

    'aplicacion/casosuso/entrada/IMinibarUseCase.java': '''package {pkg}.aplicacion.casosuso.entrada;
import {pkg}.dominio.entidades.Minibar;
import java.util.List;
public interface IMinibarUseCase {
    Minibar guardar(Minibar minibar);
    List<Minibar> listarTodos();
    Minibar buscarPorId(int id);
    void eliminar(int id);
}
'''.replace('{pkg}', base_pkg),

    'aplicacion/casosuso/impl/MinibarUseCaseImpl.java': '''package {pkg}.aplicacion.casosuso.impl;
import {pkg}.aplicacion.casosuso.entrada.IMinibarUseCase;
import {pkg}.dominio.entidades.Minibar;
import {pkg}.dominio.repositorios.IMinibarRepositorio;
import java.util.List;
public class MinibarUseCaseImpl implements IMinibarUseCase {
    private final IMinibarRepositorio repositorio;
    public MinibarUseCaseImpl(IMinibarRepositorio repositorio) { this.repositorio = repositorio; }
    @Override public Minibar guardar(Minibar minibar) { return repositorio.guardar(minibar); }
    @Override public List<Minibar> listarTodos() { return repositorio.listarTodos(); }
    @Override public Minibar buscarPorId(int id) { return repositorio.buscarPorId(id); }
    @Override public void eliminar(int id) { repositorio.eliminar(id); }
}
'''.replace('{pkg}', base_pkg),

    'infraestructura/persistencia/jpa/MinibarEntity.java': '''package {pkg}.infraestructura.persistencia.jpa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;
@Data
@Entity
@Table(name = "minibar")
public class MinibarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_minibar")
    private int id_minibar;
    
    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id_habitacion", nullable = false)
    private HabitacionEntity habitacion;
    
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false)
    private ProductoEntity producto;
    
    @Column(name = "cantidad")
    private int cantidad;
}
'''.replace('{pkg}', base_pkg),

    'infraestructura/repositorios/IMinibarJpaRepositorio.java': '''package {pkg}.infraestructura.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import {pkg}.infraestructura.persistencia.jpa.MinibarEntity;
public interface IMinibarJpaRepositorio extends JpaRepository<MinibarEntity, Integer> {
}
'''.replace('{pkg}', base_pkg),

    'infraestructura/persistencia/mapeadores/IMinibarJpaMapper.java': '''package {pkg}.infraestructura.persistencia.mapeadores;
import org.mapstruct.Mapper;
import {pkg}.dominio.entidades.Minibar;
import {pkg}.infraestructura.persistencia.jpa.MinibarEntity;
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IMinibarJpaMapper {
    @org.mapstruct.Mapping(source = "habitacion.id_habitacion", target = "id_habitacion")
    @org.mapstruct.Mapping(source = "producto.id_producto", target = "id_producto")
    Minibar toDomain(MinibarEntity entity);
    
    @org.mapstruct.Mapping(source = "id_habitacion", target = "habitacion.id_habitacion")
    @org.mapstruct.Mapping(source = "id_producto", target = "producto.id_producto")
    MinibarEntity toEntity(Minibar domain);
}
'''.replace('{pkg}', base_pkg),

    'infraestructura/persistencia/adaptadores/MinibarRepositorioImpl.java': '''package {pkg}.infraestructura.persistencia.adaptadores;
import {pkg}.dominio.entidades.Minibar;
import {pkg}.dominio.repositorios.IMinibarRepositorio;
import {pkg}.infraestructura.persistencia.jpa.MinibarEntity;
import {pkg}.infraestructura.persistencia.mapeadores.IMinibarJpaMapper;
import {pkg}.infraestructura.repositorios.IMinibarJpaRepositorio;
import {pkg}.infraestructura.repositorios.IHabitacionJpaRepositorio;
import {pkg}.infraestructura.repositorios.IProductoJpaRepositorio;
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
'''.replace('{pkg}', base_pkg),

    'presentacion/dto/request/MinibarRequestDTO.java': '''package {pkg}.presentacion.dto.request;
import lombok.Data;
@Data
public class MinibarRequestDTO {
    private int idMinibar;
    private int idHabitacion;
    private int idProducto;
    private int cantidad;
}
'''.replace('{pkg}', base_pkg),

    'presentacion/dto/response/MinibarResponseDTO.java': '''package {pkg}.presentacion.dto.response;
import lombok.Data;
@Data
public class MinibarResponseDTO {
    private Long idMinibar;
    private Long idHabitacion;
    private Long idProducto;
    private Integer cantidad;
}
'''.replace('{pkg}', base_pkg),

    'presentacion/mapeadores/IMinibarDtoMapper.java': '''package {pkg}.presentacion.mapeadores;
import org.mapstruct.Mapper;
import {pkg}.dominio.entidades.Minibar;
import {pkg}.presentacion.dto.request.MinibarRequestDTO;
import {pkg}.presentacion.dto.response.MinibarResponseDTO;
@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface IMinibarDtoMapper {
    @org.mapstruct.Mapping(source = "idMinibar", target = "id_minibar")
    @org.mapstruct.Mapping(source = "idHabitacion", target = "id_habitacion")
    @org.mapstruct.Mapping(source = "idProducto", target = "id_producto")
    Minibar toDomain(MinibarRequestDTO dto);
    
    @org.mapstruct.Mapping(source = "id_minibar", target = "idMinibar")
    @org.mapstruct.Mapping(source = "id_habitacion", target = "idHabitacion")
    @org.mapstruct.Mapping(source = "id_producto", target = "idProducto")
    MinibarResponseDTO toResponseDto(Minibar entity);
}
'''.replace('{pkg}', base_pkg),

    'presentacion/controladores/MinibarController.java': '''package {pkg}.presentacion.controladores;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import {pkg}.aplicacion.casosuso.entrada.IMinibarUseCase;
import {pkg}.dominio.entidades.Minibar;
import {pkg}.presentacion.dto.request.MinibarRequestDTO;
import {pkg}.presentacion.dto.response.MinibarResponseDTO;
import {pkg}.presentacion.mapeadores.IMinibarDtoMapper;

@RestController
@RequestMapping("/api/minibar")
public class MinibarController {
    private final IMinibarUseCase useCase;
    private final IMinibarDtoMapper mapper;
    public MinibarController(IMinibarUseCase useCase, IMinibarDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }
    @GetMapping
    public ResponseEntity<List<MinibarResponseDTO>> listarTodos() {
        List<MinibarResponseDTO> list = useCase.listarTodos().stream().map(mapper::toResponseDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MinibarResponseDTO> buscarPorId(@PathVariable int id) {
        Minibar entity = useCase.buscarPorId(id);
        if (entity != null) return new ResponseEntity<>(mapper.toResponseDto(entity), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<MinibarResponseDTO> guardar(@RequestBody MinibarRequestDTO request) {
        Minibar entity = useCase.guardar(mapper.toDomain(request));
        return new ResponseEntity<>(mapper.toResponseDto(entity), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MinibarResponseDTO> actualizar(@PathVariable int id, @RequestBody MinibarRequestDTO request) {
        request.setIdMinibar(id);
        Minibar entity = useCase.guardar(mapper.toDomain(request));
        return new ResponseEntity<>(mapper.toResponseDto(entity), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        useCase.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
'''.replace('{pkg}', base_pkg)
}

import os
for rel_path, content in files.items():
    full_path = os.path.join(base_dir, rel_path)
    os.makedirs(os.path.dirname(full_path), exist_ok=True)
    with open(full_path, 'w', encoding='utf-8') as f:
        f.write(content)
print("Files generated successfully.")

package com.proyecto.hotel.presentacion.controladores;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IProductoUseCase;
import com.proyecto.hotel.dominio.entidades.Producto;
import com.proyecto.hotel.presentacion.dto.request.ProductoRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.ProductoResponseDTO;
import com.proyecto.hotel.presentacion.mapeadores.IProductoDtoMapper;

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

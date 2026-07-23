package com.proyecto.hotel.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IProductoUseCase;
import com.proyecto.hotel.presentacion.dto.request.ProductoRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.ProductoResponseDTO;
import com.proyecto.hotel.presentacion.mapeadores.IProductoDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/producto")
public class ProductoController {
    
    private final IProductoUseCase ProductoUseCase;
    private final IProductoDtoMapper ProductoMapper;

    public ProductoController(IProductoUseCase ProductoUseCase, IProductoDtoMapper ProductoMapper) {
        super();
        this.ProductoUseCase = ProductoUseCase;
        this.ProductoMapper = ProductoMapper;
    }
    
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoResponseDTO guardar(@Valid @RequestBody ProductoRequestDTO ProductoRequestDto) {
        return ProductoMapper.toResponseDto(ProductoUseCase.guardar(ProductoMapper.toDomain(ProductoRequestDto)));
    }
    
    
    @PutMapping("/{id}")
    public ProductoResponseDTO actualizar(
            @PathVariable int id, 
            @Valid @RequestBody ProductoRequestDTO ProductoRequestDto) {
        var ProductoDomain = ProductoMapper.toDomain(ProductoRequestDto);
        var resultado = ProductoUseCase.actualizar(id, ProductoDomain);
        return ProductoMapper.toResponseDto(resultado);
    }
    
    

    @GetMapping
    public List<ProductoResponseDTO> listarTodo() {
        return ProductoUseCase.listarTodos().stream().map(ProductoMapper::toResponseDto).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        ProductoUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
package com.proyecto.hotel.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.presentacion.dto.response.SuccessResponse;
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
    public SuccessResponse<ProductoResponseDTO> guardar(@Valid @RequestBody ProductoRequestDTO ProductoRequestDto)  {
        ProductoResponseDTO res = ProductoMapper.toResponseDto(ProductoUseCase.guardar(ProductoMapper.toDomain(ProductoRequestDto)));
        return new SuccessResponse<>(HttpStatus.CREATED.value(), "Ingreso correcto", res);
    }
    
    
    @PutMapping("/{id}")
    public SuccessResponse<ProductoResponseDTO> actualizar(
            @PathVariable int id, 
            @Valid @RequestBody ProductoRequestDTO ProductoRequestDto) {
        var ProductoDomain = ProductoMapper.toDomain(ProductoRequestDto);
        var resultado = ProductoUseCase.actualizar(id, ProductoDomain);
        ProductoResponseDTO res = ProductoMapper.toResponseDto(resultado);
        return new SuccessResponse<>(HttpStatus.OK.value(), "Edición correcta", res);
    }
    
    

    @GetMapping
    public List<ProductoResponseDTO> listarTodo() {
        return ProductoUseCase.listarTodos().stream().map(ProductoMapper::toResponseDto).toList();
    }


    @GetMapping("/{id}")
    public ProductoResponseDTO buscarPorId(@PathVariable("id") int id) {
        return ProductoMapper.toResponseDto(ProductoUseCase.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public SuccessResponse<ProductoResponseDTO> eliminar(@PathVariable("id") int id) {
        ProductoResponseDTO dto = ProductoMapper.toResponseDto(ProductoUseCase.buscarPorId(id));
        ProductoUseCase.eliminar(id);
        return new SuccessResponse<>(org.springframework.http.HttpStatus.OK.value(), "Registro borrado exitosamente", dto);
    }
}
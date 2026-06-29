package com.proyecto.hotel.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.aplicacion.casosuso.entrada.ICatalogoServicioUseCase;
import com.proyecto.hotel.presentacion.dto.request.CatalogoServicioRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.CatalogoServicioResponseDTO;
import com.proyecto.hotel.presentacion.mapeadores.ICatalogoServicioDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/catalogo")
@CrossOrigin(origins = "http://localhost:4200")
public class CatalogoServicioController {

    private final ICatalogoServicioUseCase catalogoUseCase;
    private final ICatalogoServicioDtoMapper catalogoMapper;

    public CatalogoServicioController(ICatalogoServicioUseCase catalogoUseCase, ICatalogoServicioDtoMapper catalogoMapper) {
        this.catalogoUseCase = catalogoUseCase;
        this.catalogoMapper = catalogoMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CatalogoServicioResponseDTO guardar(@Valid @RequestBody CatalogoServicioRequestDTO dto) {
        return catalogoMapper.toResponseDto(catalogoUseCase.guardar(catalogoMapper.toDomain(dto)));
    }

    @PutMapping("/{id}")
    public CatalogoServicioResponseDTO actualizar(@PathVariable int id, @Valid @RequestBody CatalogoServicioRequestDTO catalogoRequestDto) {
        return catalogoMapper.toResponseDto(catalogoUseCase.actualizar(id, catalogoMapper.toDomain(catalogoRequestDto)));
    }

    @GetMapping
    public List<CatalogoServicioResponseDTO> listarTodo() {
        return catalogoUseCase.listarTodos().stream().map(catalogoMapper::toResponseDto).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<java.util.Map<String, String>> eliminar(@PathVariable int id) {
        catalogoUseCase.eliminar(id);
        return ResponseEntity.ok(java.util.Map.of("mensaje", "Servicio eliminado correctamente"));
    }
}

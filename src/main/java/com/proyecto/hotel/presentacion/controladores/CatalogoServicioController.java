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

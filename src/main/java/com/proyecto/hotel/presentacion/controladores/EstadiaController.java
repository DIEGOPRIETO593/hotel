package com.proyecto.hotel.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IEstadiaUseCase;
import com.proyecto.hotel.presentacion.dto.request.EstadiaRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.EstadiaResponseDTO;
import com.proyecto.hotel.presentacion.mapeadores.IEstadiaDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/estadia")
public class EstadiaController {
    
    private final IEstadiaUseCase estadiaUseCase;
    private final IEstadiaDtoMapper estadiaMapper;

    public EstadiaController(IEstadiaUseCase estadiaUseCase, IEstadiaDtoMapper estadiaMapper) {
        super();
        this.estadiaUseCase = estadiaUseCase;
        this.estadiaMapper = estadiaMapper;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstadiaResponseDTO guardar(@Valid @RequestBody EstadiaRequestDTO estadiaRequestDto) {
        return estadiaMapper.toResponseDto(estadiaUseCase.guardar(estadiaMapper.toDomain(estadiaRequestDto)));
    }

    @GetMapping
    public List<EstadiaResponseDTO> listarTodo() {
        return estadiaUseCase.listarTodos().stream().map(estadiaMapper::toResponseDto).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        estadiaUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
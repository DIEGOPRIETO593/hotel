package com.proyecto.hotel.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IMinibarUseCase;
import com.proyecto.hotel.presentacion.dto.request.MinibarRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.MinibarResponseDTO;
import com.proyecto.hotel.presentacion.mapeadores.IMinibarDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/minibar")
public class MinibarController {
    
    private final IMinibarUseCase MinibarUseCase;
    private final IMinibarDtoMapper MinibarMapper;

    public MinibarController(IMinibarUseCase MinibarUseCase, IMinibarDtoMapper MinibarMapper) {
        super();
        this.MinibarUseCase = MinibarUseCase;
        this.MinibarMapper = MinibarMapper;
    }
    
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MinibarResponseDTO guardar(@Valid @RequestBody MinibarRequestDTO MinibarRequestDto) {
        return MinibarMapper.toResponseDto(MinibarUseCase.guardar(MinibarMapper.toDomain(MinibarRequestDto)));
    }
    
    
    @PutMapping("/{id}")
    public MinibarResponseDTO actualizar(
            @PathVariable int id, 
            @Valid @RequestBody MinibarRequestDTO MinibarRequestDto) {
        var MinibarDomain = MinibarMapper.toDomain(MinibarRequestDto);
        var resultado = MinibarUseCase.actualizar(id, MinibarDomain);
        return MinibarMapper.toResponseDto(resultado);
    }
    
    

    @GetMapping
    public List<MinibarResponseDTO> listarTodo() {
        return MinibarUseCase.listarTodos().stream().map(MinibarMapper::toResponseDto).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        MinibarUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
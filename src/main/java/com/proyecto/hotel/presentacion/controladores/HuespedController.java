package com.proyecto.hotel.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IHuespedUseCase;
import com.proyecto.hotel.presentacion.dto.request.HuespedRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.HuespedResponseDTO;
import com.proyecto.hotel.presentacion.mapeadores.IHuespedDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/huesped")
@CrossOrigin(origins = "http://localhost:4200")
public class HuespedController {
    
    private final IHuespedUseCase huespedUseCase;
    private final IHuespedDtoMapper huespedMapper;

    public HuespedController(IHuespedUseCase huespedUseCase, IHuespedDtoMapper huespedMapper) {
        super();
        this.huespedUseCase = huespedUseCase;
        this.huespedMapper = huespedMapper;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HuespedResponseDTO guardar(@Valid @RequestBody HuespedRequestDTO huespedRequestDto) {
        return huespedMapper.toResponseDto(huespedUseCase.guardar(huespedMapper.toDomain(huespedRequestDto)));
    }

    @GetMapping
    public List<HuespedResponseDTO> listarTodo() {
        return huespedUseCase.listarTodos().stream().map(huespedMapper::toResponseDto).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<java.util.Map<String, String>> eliminar(@PathVariable int id) {
        huespedUseCase.eliminar(id);
        return ResponseEntity.ok(java.util.Map.of("mensaje", "Huésped eliminado correctamente"));
    }
}
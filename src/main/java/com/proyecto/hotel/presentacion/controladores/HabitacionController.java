package com.proyecto.hotel.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IHabitacionUseCase;
import com.proyecto.hotel.presentacion.dto.request.HabitacionRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.HabitacionResponseDTO;
import com.proyecto.hotel.presentacion.mapeadores.IHabitacionDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/habitacion")
public class HabitacionController {
    
    private final IHabitacionUseCase habitacionUseCase;
    private final IHabitacionDtoMapper habitacionMapper;

    public HabitacionController(IHabitacionUseCase habitacionUseCase, IHabitacionDtoMapper habitacionMapper) {
        super();
        this.habitacionUseCase = habitacionUseCase;
        this.habitacionMapper = habitacionMapper;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HabitacionResponseDTO guardar(@Valid @RequestBody HabitacionRequestDTO habitacionRequestDto) {
        return habitacionMapper.toResponseDto(habitacionUseCase.guardar(habitacionMapper.toDomain(habitacionRequestDto)));
    }

    @PutMapping("/{id}")
    public HabitacionResponseDTO actualizar(@PathVariable int id, @Valid @RequestBody HabitacionRequestDTO habitacionRequestDto) {
        return habitacionMapper.toResponseDto(habitacionUseCase.actualizar(id, habitacionMapper.toDomain(habitacionRequestDto)));
    }

    @GetMapping
    public List<HabitacionResponseDTO> listarTodo() {
        return habitacionUseCase.listarTodos().stream().map(habitacionMapper::toResponseDto).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<java.util.Map<String, String>> eliminar(@PathVariable int id) {
        habitacionUseCase.eliminar(id);
        return ResponseEntity.ok(java.util.Map.of("mensaje", "Habitación eliminada correctamente"));
    }
}
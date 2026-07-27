package com.proyecto.hotel.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.presentacion.dto.response.SuccessResponse;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IHabitacionUseCase;
import com.proyecto.hotel.presentacion.dto.request.HabitacionRequestDTO;
import com.proyecto.hotel.presentacion.dto.request.HuespedRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.HabitacionResponseDTO;
import com.proyecto.hotel.presentacion.dto.response.HuespedResponseDTO;
import com.proyecto.hotel.presentacion.mapeadores.IHabitacionDtoMapper;
import jakarta.validation.Valid;

/**
 * Controlador REST: Gestión de endpoints para Habitaciones.
 * Capa: Presentación / API REST.
 * Expone los servicios de habitaciones bajo el prefijo '/api/habitaciones', consumidos por el cliente web WebClient.
 */
@RestController
@RequestMapping("api/habitacion")
@CrossOrigin(origins = "http://localhost:4200")
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
	public SuccessResponse<HabitacionResponseDTO> guardar(@Valid @RequestBody HabitacionRequestDTO habitacionRequestDto) {
		HabitacionResponseDTO res = habitacionMapper.toResponseDto(habitacionUseCase.guardar(habitacionMapper.toDomain(habitacionRequestDto)));
        return new SuccessResponse<>(HttpStatus.CREATED.value(), "Ingreso correcto", res);
	}
	
	@PutMapping("/{id}")
    public SuccessResponse<HabitacionResponseDTO> actualizar(
            @PathVariable int id, 
            @Valid @RequestBody HabitacionRequestDTO habitacionRequestDto) { 
        var habitacionDomain = habitacionMapper.toDomain(habitacionRequestDto);
        var resultado = habitacionUseCase.actualizar(id, habitacionDomain);
        HabitacionResponseDTO res = habitacionMapper.toResponseDto(resultado);
        return new SuccessResponse<>(HttpStatus.OK.value(), "Edición correcta", res);
    }

	@GetMapping
	public List<HabitacionResponseDTO> listarTodo() {
		return habitacionUseCase.listarTodos().stream().map(habitacionMapper::toResponseDto).toList();
	}


    @GetMapping("/{id}")
    public HabitacionResponseDTO buscarPorId(@PathVariable("id") int id) {
        return habitacionMapper.toResponseDto(habitacionUseCase.buscarPorId(id));
    }

	@DeleteMapping("/{id}")
	public SuccessResponse<HabitacionResponseDTO> eliminar(@PathVariable int id) {
        HabitacionResponseDTO dto = habitacionMapper.toResponseDto(habitacionUseCase.buscarPorId(id));
		habitacionUseCase.eliminar(id);
		return new SuccessResponse<>(HttpStatus.OK.value(), "Registro borrado exitosamente", dto);
	}

	
	
	@GetMapping("/buscar")
	public List<HabitacionResponseDTO> buscarHabitaciones(
			@RequestParam(required = false, defaultValue = "0") String estado) {

		return habitacionUseCase.buscarPorEstado(estado).stream().map(habitacionMapper::toResponseDto).toList();

	}
}
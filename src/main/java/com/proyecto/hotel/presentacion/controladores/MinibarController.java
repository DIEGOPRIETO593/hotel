package com.proyecto.hotel.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.presentacion.dto.response.SuccessResponse;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IMinibarUseCase;
import com.proyecto.hotel.presentacion.dto.request.MinibarRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.MinibarResponseDTO;
import com.proyecto.hotel.presentacion.mapeadores.IMinibarDtoMapper;
import jakarta.validation.Valid;

/**
 * Controlador REST: Gestión de endpoints para consumos de Minibar.
 * Capa: Presentación / API REST.
 * Expone operaciones CRUD y consultas especializadas por habitación bajo '/api/minibar'.
 */
@RestController
@RequestMapping("api/minibar")
@CrossOrigin(origins = "http://localhost:4200")
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
    public SuccessResponse<MinibarResponseDTO> guardar(@Valid @RequestBody MinibarRequestDTO MinibarRequestDto)  {
        MinibarResponseDTO res = MinibarMapper.toResponseDto(MinibarUseCase.guardar(MinibarMapper.toDomain(MinibarRequestDto)));
        return new SuccessResponse<>(HttpStatus.CREATED.value(), "Ingreso correcto", res);
    }
    
    
    @PutMapping("/{id}")
    public SuccessResponse<MinibarResponseDTO> actualizar(
            @PathVariable int id, 
            @Valid @RequestBody MinibarRequestDTO MinibarRequestDto) {
        var MinibarDomain = MinibarMapper.toDomain(MinibarRequestDto);
        var resultado = MinibarUseCase.actualizar(id, MinibarDomain);
        MinibarResponseDTO res = MinibarMapper.toResponseDto(resultado);
        return new SuccessResponse<>(HttpStatus.OK.value(), "Edición correcta", res);
    }
    
    

    @GetMapping
    public List<MinibarResponseDTO> listarTodo() {
        return MinibarUseCase.listarTodos().stream().map(MinibarMapper::toResponseDto).toList();
    }


    @GetMapping("/{id}")
    public MinibarResponseDTO buscarPorId(@PathVariable("id") int id) {
        return MinibarMapper.toResponseDto(MinibarUseCase.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public SuccessResponse<MinibarResponseDTO> eliminar(@PathVariable("id") int id) {
        MinibarResponseDTO dto = MinibarMapper.toResponseDto(MinibarUseCase.buscarPorId(id));
        MinibarUseCase.eliminar(id);
        return new SuccessResponse<>(org.springframework.http.HttpStatus.OK.value(), "Registro borrado exitosamente", dto);
    }
}
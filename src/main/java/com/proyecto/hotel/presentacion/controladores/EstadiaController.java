package com.proyecto.hotel.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.presentacion.dto.response.SuccessResponse;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IEstadiaUseCase;
import com.proyecto.hotel.presentacion.dto.request.EstadiaRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.EstadiaResponseDTO;
import com.proyecto.hotel.presentacion.mapeadores.IEstadiaDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/estadia")
@CrossOrigin(origins = "http://localhost:4200")
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
    public SuccessResponse<EstadiaResponseDTO> guardar(@Valid @RequestBody EstadiaRequestDTO estadiaRequestDto)  {
        EstadiaResponseDTO res = estadiaMapper.toResponseDto(estadiaUseCase.guardar(estadiaMapper.toDomain(estadiaRequestDto)));
        return new SuccessResponse<>(HttpStatus.CREATED.value(), "Ingreso correcto", res);
    }
    
    @PutMapping("/{id}")
    public SuccessResponse<EstadiaResponseDTO> actualizar(
            @PathVariable int id, 
            @Valid @RequestBody EstadiaRequestDTO estadiaRequestDto) {
        
        var estadiaDomain = estadiaMapper.toDomain(estadiaRequestDto);
        var resultado = estadiaUseCase.actualizar(id, estadiaDomain);
        EstadiaResponseDTO res = estadiaMapper.toResponseDto(resultado);
        return new SuccessResponse<>(HttpStatus.OK.value(), "Edición correcta", res);
    }

    @GetMapping
    public List<EstadiaResponseDTO> listarTodo() {
        return estadiaUseCase.listarTodos().stream().map(estadiaMapper::toResponseDto).toList();
    }


    @GetMapping("/{id}")
    public EstadiaResponseDTO buscarPorId(@PathVariable("id") int id) {
        return estadiaMapper.toResponseDto(estadiaUseCase.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public SuccessResponse<EstadiaResponseDTO> eliminar(@PathVariable("id") int id) {
        EstadiaResponseDTO dto = estadiaMapper.toResponseDto(estadiaUseCase.buscarPorId(id));
        estadiaUseCase.eliminar(id);
        return new SuccessResponse<>(org.springframework.http.HttpStatus.OK.value(), "Registro borrado exitosamente", dto);
    }
}
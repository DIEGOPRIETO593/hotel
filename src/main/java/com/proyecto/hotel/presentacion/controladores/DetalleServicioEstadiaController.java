package com.proyecto.hotel.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IDetalleServicioEstadiaUseCase;
import com.proyecto.hotel.presentacion.dto.request.DetalleServicioEstadiaRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.DetalleServicioEstadiaResponseDTO;
import com.proyecto.hotel.presentacion.mapeadores.IDetalleServicioEstadiaDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/detalle")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleServicioEstadiaController {
    
    private final IDetalleServicioEstadiaUseCase detalleUseCase;
    private final IDetalleServicioEstadiaDtoMapper detalleMapper;

    public DetalleServicioEstadiaController(IDetalleServicioEstadiaUseCase detalleUseCase, IDetalleServicioEstadiaDtoMapper detalleMapper) {
        super();
        this.detalleUseCase = detalleUseCase;
        this.detalleMapper = detalleMapper;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleServicioEstadiaResponseDTO guardar(@Valid @RequestBody DetalleServicioEstadiaRequestDTO detalleRequestDto) {
        return detalleMapper.toResponseDto(detalleUseCase.guardar(detalleMapper.toDomain(detalleRequestDto)));
    }
    
    @PutMapping("/{id}")
    public DetalleServicioEstadiaResponseDTO actualizar(
            @PathVariable int id, 
            @Valid @RequestBody DetalleServicioEstadiaRequestDTO detalleRequestDto) {
        var detalleServicioDomain = detalleMapper.toDomain(detalleRequestDto);
        var resultado = detalleUseCase.actualizar(id, detalleServicioDomain);
        return detalleMapper.toResponseDto(resultado);
    }

    @GetMapping
    public List<DetalleServicioEstadiaResponseDTO> listarTodo() {
        return detalleUseCase.listarTodos().stream().map(detalleMapper::toResponseDto).toList();
    }

    @GetMapping("/{id}")
    public DetalleServicioEstadiaResponseDTO buscarPorId(@PathVariable("id") int id) {
        return detalleMapper.toResponseDto(detalleUseCase.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        detalleUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
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

    @GetMapping
    public List<DetalleServicioEstadiaResponseDTO> listarTodo() {
        return detalleUseCase.listarTodos().stream().map(detalleMapper::toResponseDto).toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<java.util.Map<String, String>> eliminar(@PathVariable int id) {
        detalleUseCase.eliminar(id);
        return ResponseEntity.ok(java.util.Map.of("mensaje", "Detalle eliminado correctamente"));
    }
}
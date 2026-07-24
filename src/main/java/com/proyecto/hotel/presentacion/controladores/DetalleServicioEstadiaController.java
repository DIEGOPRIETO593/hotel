package com.proyecto.hotel.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.presentacion.dto.response.SuccessResponse;
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
    public SuccessResponse<DetalleServicioEstadiaResponseDTO> guardar(@Valid @RequestBody DetalleServicioEstadiaRequestDTO detalleRequestDto)  {
        DetalleServicioEstadiaResponseDTO res = detalleMapper.toResponseDto(detalleUseCase.guardar(detalleMapper.toDomain(detalleRequestDto)));
        return new SuccessResponse<>(HttpStatus.CREATED.value(), "Ingreso correcto", res);
    }
    
    @PutMapping("/{id}")
    public SuccessResponse<DetalleServicioEstadiaResponseDTO> actualizar(
            @PathVariable int id, 
            @Valid @RequestBody DetalleServicioEstadiaRequestDTO detalleRequestDto) {
        var detalleServicioDomain = detalleMapper.toDomain(detalleRequestDto);
        var resultado = detalleUseCase.actualizar(id, detalleServicioDomain);
        DetalleServicioEstadiaResponseDTO res = detalleMapper.toResponseDto(resultado);
        return new SuccessResponse<>(HttpStatus.OK.value(), "Edición correcta", res);
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
    public SuccessResponse<DetalleServicioEstadiaResponseDTO> eliminar(@PathVariable("id") int id) {
        DetalleServicioEstadiaResponseDTO dto = detalleMapper.toResponseDto(detalleUseCase.buscarPorId(id));
        detalleUseCase.eliminar(id);
        return new SuccessResponse<>(org.springframework.http.HttpStatus.OK.value(), "Registro borrado exitosamente", dto);
    }
}
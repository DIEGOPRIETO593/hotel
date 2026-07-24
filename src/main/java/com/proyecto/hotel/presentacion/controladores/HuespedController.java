package com.proyecto.hotel.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.presentacion.dto.response.SuccessResponse;
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
    public SuccessResponse<HuespedResponseDTO> guardar(@Valid @RequestBody HuespedRequestDTO huespedRequestDto)  {
        HuespedResponseDTO res = huespedMapper.toResponseDto(huespedUseCase.guardar(huespedMapper.toDomain(huespedRequestDto)));
        return new SuccessResponse<>(HttpStatus.CREATED.value(), "Ingreso correcto", res);
    }
    
    
    @PutMapping("/{id}")
    public SuccessResponse<HuespedResponseDTO> actualizar(
            @PathVariable int id, 
            @Valid @RequestBody HuespedRequestDTO huespedRequestDto) {
        var huespedDomain = huespedMapper.toDomain(huespedRequestDto);
        var resultado = huespedUseCase.actualizar(id, huespedDomain);
        HuespedResponseDTO res = huespedMapper.toResponseDto(resultado);
        return new SuccessResponse<>(HttpStatus.OK.value(), "Edición correcta", res);
    }
    
    

    @GetMapping
    public List<HuespedResponseDTO> listarTodo() {
        return huespedUseCase.listarTodos().stream().map(huespedMapper::toResponseDto).toList();
    }


    @GetMapping("/{id}")
    public HuespedResponseDTO buscarPorId(@PathVariable("id") int id) {
        return huespedMapper.toResponseDto(huespedUseCase.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public SuccessResponse<HuespedResponseDTO> eliminar(@PathVariable("id") int id) {
        HuespedResponseDTO dto = huespedMapper.toResponseDto(huespedUseCase.buscarPorId(id));
        huespedUseCase.eliminar(id);
        return new SuccessResponse<>(org.springframework.http.HttpStatus.OK.value(), "Registro borrado exitosamente", dto);
    }
}
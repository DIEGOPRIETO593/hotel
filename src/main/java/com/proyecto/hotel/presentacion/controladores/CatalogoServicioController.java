package com.proyecto.hotel.presentacion.controladores;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.presentacion.dto.response.SuccessResponse;
import com.proyecto.hotel.aplicacion.casosuso.entrada.ICatalogoServicioUseCase;
import com.proyecto.hotel.presentacion.dto.request.CatalogoServicioRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.CatalogoServicioResponseDTO;
import com.proyecto.hotel.presentacion.mapeadores.ICatalogoServicioDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/catalogo")
@CrossOrigin(origins = "http://localhost:4200")
public class CatalogoServicioController {

    private final ICatalogoServicioUseCase catalogoUseCase;
    private final ICatalogoServicioDtoMapper catalogoMapper;

    public CatalogoServicioController(ICatalogoServicioUseCase catalogoUseCase, ICatalogoServicioDtoMapper catalogoMapper) {
        this.catalogoUseCase = catalogoUseCase;
        this.catalogoMapper = catalogoMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuccessResponse<CatalogoServicioResponseDTO> guardar(@Valid @RequestBody CatalogoServicioRequestDTO dto)  {
        CatalogoServicioResponseDTO res = catalogoMapper.toResponseDto(catalogoUseCase.guardar(catalogoMapper.toDomain(dto)));
        return new SuccessResponse<>(HttpStatus.CREATED.value(), "Ingreso correcto", res);
    }
    
    @PutMapping("/{id}")
    public SuccessResponse<CatalogoServicioResponseDTO> actualizar(
            @PathVariable int id, 
            @Valid @RequestBody CatalogoServicioRequestDTO catalogoRequestDto) {
        var catalogoDomain = catalogoMapper.toDomain(catalogoRequestDto);
        var resultado = catalogoUseCase.actualizar(id, catalogoDomain);
        CatalogoServicioResponseDTO res = catalogoMapper.toResponseDto(resultado);
        return new SuccessResponse<>(HttpStatus.OK.value(), "Edición correcta", res);
    }

    @GetMapping
    public List<CatalogoServicioResponseDTO> listarTodo() {
        return catalogoUseCase.listarTodos().stream().map(catalogoMapper::toResponseDto).toList();
    }


    @GetMapping("/{id}")
    public CatalogoServicioResponseDTO buscarPorId(@PathVariable("id") int id) {
        return catalogoMapper.toResponseDto(catalogoUseCase.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public SuccessResponse<CatalogoServicioResponseDTO> eliminar(@PathVariable("id") int id) {
        CatalogoServicioResponseDTO dto = catalogoMapper.toResponseDto(catalogoUseCase.buscarPorId(id));
        catalogoUseCase.eliminar(id);
        return new SuccessResponse<>(org.springframework.http.HttpStatus.OK.value(), "Registro borrado exitosamente", dto);
    }
}

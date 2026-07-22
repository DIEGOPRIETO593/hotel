package com.proyecto.hotel.presentacion.controladores;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.hotel.aplicacion.casosuso.entrada.IMinibarUseCase;
import com.proyecto.hotel.dominio.entidades.Minibar;
import com.proyecto.hotel.presentacion.dto.request.MinibarRequestDTO;
import com.proyecto.hotel.presentacion.dto.response.MinibarResponseDTO;
import com.proyecto.hotel.presentacion.mapeadores.IMinibarDtoMapper;

@RestController
@RequestMapping("/api/minibar")
public class MinibarController {
    private final IMinibarUseCase useCase;
    private final IMinibarDtoMapper mapper;
    public MinibarController(IMinibarUseCase useCase, IMinibarDtoMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }
    @GetMapping
    public ResponseEntity<List<MinibarResponseDTO>> listarTodos() {
        List<MinibarResponseDTO> list = useCase.listarTodos().stream().map(mapper::toResponseDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MinibarResponseDTO> buscarPorId(@PathVariable int id) {
        Minibar entity = useCase.buscarPorId(id);
        if (entity != null) return new ResponseEntity<>(mapper.toResponseDto(entity), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<MinibarResponseDTO> guardar(@RequestBody MinibarRequestDTO request) {
        Minibar entity = useCase.guardar(mapper.toDomain(request));
        return new ResponseEntity<>(mapper.toResponseDto(entity), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MinibarResponseDTO> actualizar(@PathVariable int id, @RequestBody MinibarRequestDTO request) {
        request.setIdMinibar(id);
        Minibar entity = useCase.guardar(mapper.toDomain(request));
        return new ResponseEntity<>(mapper.toResponseDto(entity), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        useCase.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

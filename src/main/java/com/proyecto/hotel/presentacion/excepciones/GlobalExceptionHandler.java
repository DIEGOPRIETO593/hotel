package com.proyecto.hotel.presentacion.excepciones;

import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Map<String, String> response = new HashMap<>();
        String errorMsg = "Error de integridad en los datos. Es posible que el registro (ej. cédula) ya exista.";
        if (ex.getMostSpecificCause() != null && ex.getMostSpecificCause().getMessage().contains("duplicate key")) {
            errorMsg = "El registro ya existe en la base de datos (clave duplicada).";
        }
        response.put("error", errorMsg);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}

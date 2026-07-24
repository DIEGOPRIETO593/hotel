package com.proyecto.hotel.presentacion.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.proyecto.hotel.aplicacion.excepciones.ResourceNotFoundException;
import com.proyecto.hotel.presentacion.dto.response.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "No Encontrado", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String msg = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Petición Inválida", msg);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrity(DataIntegrityViolationException ex) {
        String mensajeDetallado = ex.getMostSpecificCause() != null ? ex.getMostSpecificCause().getMessage() : ex.getMessage();
        
        String mensajeUsuario = "No se puede realizar la operación por restricciones de base de datos.";
        
        if (mensajeDetallado.contains("cedula") || mensajeDetallado.contains("uk_")) {
            mensajeUsuario = "La cédula ingresada ya existe. Detalle técnico: " + mensajeDetallado;
        } else if (mensajeDetallado.contains("violates foreign key constraint") || mensajeDetallado.contains("fk_")) {
            mensajeUsuario = "No se puede eliminar o agregar el registro porque está siendo usado por otra tabla (Ej: Huésped con Estadía). Detalle técnico: " + mensajeDetallado;
        } else {
            mensajeUsuario = "Conflicto en la base de datos: " + mensajeDetallado;
        }

        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Conflicto de Datos", mensajeUsuario);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Petición Inválida", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error del Servidor", "Ha ocurrido un error inesperado: " + ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

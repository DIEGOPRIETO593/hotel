package com.proyecto.hotel.aplicacion.excepciones;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

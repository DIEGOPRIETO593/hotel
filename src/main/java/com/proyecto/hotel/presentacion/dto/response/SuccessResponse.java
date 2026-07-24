package com.proyecto.hotel.presentacion.dto.response;

import java.time.LocalDateTime;

public class SuccessResponse<T> {
    private int status;
    private String message;
    private LocalDateTime timestamp;
    private T dato;

    public SuccessResponse(int status, String message, T dato) {
        this.status = status;
        this.message = message;
        this.dato = dato;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public T getDato() { return dato; }
    public void setDato(T dato) { this.dato = dato; }
}

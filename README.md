# Documentación de la API REST (Hotel Master)

Esta es una documentación temporal de los endpoints disponibles en el proyecto. 
Todos los endpoints están alojados en la URL base: `http://localhost:8080/api` (o el puerto configurado).

---

## 1. Huéspedes (`/api/huesped`)

### `GET /api/huesped`
- **Descripción**: Obtiene la lista de todos los huéspedes registrados.
- **Respuestas**:
  - `200 OK`: Devuelve un arreglo JSON con la lista de huéspedes.
    ```json
    [
      {
        "idHuesped": 1,
        "cedula": "1234567890",
        "nombre": "Juan",
        "apellido": "Pérez",
        "telefono": "0991234567"
      }
    ]
    ```

### `POST /api/huesped`
- **Descripción**: Registra un nuevo huésped.
- **Cuerpo de la Petición (`HuespedRequestDTO`)**:
  ```json
  {
    "cedula": "1234567890",
    "nombre": "Juan",
    "apellido": "Pérez",
    "telefono": "0991234567"
  }
  ```
- **Respuestas**:
  - `201 Created`: Devuelve el huésped creado con su `idHuesped`.
  - `400 Bad Request`: Si hay errores de validación.

### `PUT /api/huesped/{id}`
- **Descripción**: Actualiza los datos de un huésped existente. Valida que la nueva cédula no pertenezca a otro huésped.
- **Cuerpo de la Petición (`HuespedRequestDTO`)**: Igual al de creación.
- **Respuestas**:
  - `200 OK`: Devuelve el huésped actualizado.
  - `400 Bad Request`: Si el huésped no existe o la cédula ya está en uso.

### `DELETE /api/huesped/{id}`
- **Descripción**: Elimina un huésped por su ID.
- **Respuestas**:
  - `200 OK`: Eliminado correctamente. Ejemplo de respuesta:
    ```json
    {
      "mensaje": "Huésped eliminado correctamente"
    }
    ```
  - `400 Bad Request`: Si el huésped no existe. Ejemplo de respuesta:
    ```json
    {
      "estado": "400",
      "mensaje": "Huésped no encontrado"
    }
    ```

---

## 2. Habitaciones (`/api/habitacion`)

### `GET /api/habitacion`
- **Descripción**: Obtiene la lista de todas las habitaciones.
- **Respuestas**:
  - `200 OK`: 
    ```json
    [
      {
        "idHabitacion": 1,
        "numero": "101",
        "estado": "DISPONIBLE",
        "piso": 1,
        "estrellas": 5,
        "capacidad": 2
      }
    ]
    ```

### `POST /api/habitacion`
- **Descripción**: Registra una nueva habitación.
- **Cuerpo de la Petición (`HabitacionRequestDTO`)**:
  ```json
  {
    "numero": "101",
    "estado": "DISPONIBLE",
    "piso": 1,
    "estrellas": 5,
    "capacidad": 2
  }
  ```
- **Respuestas**:
  - `201 Created`: Habitación registrada.
  - `400 Bad Request`: Error de validación.

### `PUT /api/habitacion/{id}`
- **Descripción**: Actualiza los datos de una habitación existente.
- **Cuerpo de la Petición (`HabitacionRequestDTO`)**: Igual al de creación.
- **Respuestas**:
  - `200 OK`: Devuelve la habitación actualizada.
  - `400 Bad Request`: Si la habitación no existe.

### `DELETE /api/habitacion/{id}`
- **Descripción**: Elimina una habitación por su ID.
- **Respuestas**:
  - `200 OK`: Eliminado correctamente. Ejemplo de respuesta:
    ```json
    {
      "mensaje": "Habitación eliminada correctamente"
    }
    ```
  - `400 Bad Request`: Si la habitación no existe. Ejemplo de respuesta:
    ```json
    {
      "estado": "400",
      "mensaje": "Habitación no encontrada"
    }
    ```

---

## 3. Estadías (`/api/estadia`)

### `GET /api/estadia`
- **Descripción**: Obtiene la lista de todas las estadías.
- **Respuestas**:
  - `200 OK`:
    ```json
    [
      {
        "idEstadia": 1,
        "idHuesped": 1,
        "idHabitacion": 1,
        "fechaIngreso": "2026-06-27T14:30:00",
        "fechaSalida": "2026-06-30T10:00:00",
        "cantidadHuespedes": 2,
        "totalPagar": 150.00
      }
    ]
    ```

### `POST /api/estadia`
- **Descripción**: Registra una nueva estadía. *Importante*: La validación de negocio no permitirá guardar si la habitación está "OCUPADA" o "EN MANTENIMIENTO".
- **Cuerpo de la Petición (`EstadiaRequestDTO`)**:
  ```json
  {
    "idHuesped": 1,
    "idHabitacion": 1,
    "fechaIngreso": "2026-06-27T14:30:00",
    "fechaSalida": "2026-06-30T10:00:00",
    "cantidadHuespedes": 2,
    "totalPagar": 150.00
  }
  ```
- **Respuestas**:
  - `201 Created`: Estadía registrada.
  - `400 / 500`: Si la habitación está ocupada o no existe.

### `PUT /api/estadia/{id}`
- **Descripción**: Actualiza una estadía existente. Valida que la habitación no esté en estado ocupado/mantenimiento, y que tanto la estadía como la habitación existan.
- **Cuerpo de la Petición (`EstadiaRequestDTO`)**: Igual al de creación.
- **Respuestas**:
  - `200 OK`: Devuelve la estadía actualizada.
  - `400 Bad Request`: Si la estadía o habitación no existen.

### `DELETE /api/estadia/{id}`
- **Descripción**: Elimina una estadía.
- **Respuestas**:
  - `200 OK`: Eliminado correctamente. Ejemplo de respuesta:
    ```json
    {
      "mensaje": "Estadía eliminada correctamente"
    }
    ```
  - `400 Bad Request`: Si la estadía no existe. Ejemplo de respuesta:
    ```json
    {
      "estado": "400",
      "mensaje": "Estadía no encontrada"
    }
    ```

---

## 4. Catálogo de Servicios (`/api/catalogo`)

### `GET /api/catalogo`
- **Descripción**: Lista todos los servicios del catálogo.
- **Respuestas**:
  - `200 OK`:
    ```json
    [
      {
        "idServicio": 1,
        "nombreServicio": "Desayuno Buffet",
        "tarifa": 15.50
      }
    ]
    ```

### `POST /api/catalogo`
- **Descripción**: Crea un nuevo servicio en el catálogo.
- **Cuerpo de la Petición (`CatalogoServicioRequestDTO`)**:
  ```json
  {
    "nombreServicio": "Desayuno Buffet",
    "tarifa": 15.50
  }
  ```
- **Respuestas**:
  - `201 Created`: Servicio registrado.

### `PUT /api/catalogo/{id}`
- **Descripción**: Actualiza un servicio del catálogo.
- **Cuerpo de la Petición (`CatalogoServicioRequestDTO`)**: Igual al de creación.
- **Respuestas**:
  - `200 OK`: Devuelve el servicio actualizado.
  - `400 Bad Request`: Si el servicio no existe.

### `DELETE /api/catalogo/{id}`
- **Descripción**: Elimina un servicio por su ID.
- **Respuestas**:
  - `200 OK`: Eliminado correctamente. Ejemplo de respuesta:
    ```json
    {
      "mensaje": "Servicio eliminado correctamente"
    }
    ```
  - `400 Bad Request`: Si el servicio no existe. Ejemplo de respuesta:
    ```json
    {
      "estado": "400",
      "mensaje": "Servicio no encontrado en el catálogo"
    }
    ```

---

## 5. Detalles de Servicio por Estadía (`/api/detalle`)

### `GET /api/detalle`
- **Descripción**: Lista los detalles de los servicios consumidos.
- **Respuestas**:
  - `200 OK`:
    ```json
    [
      {
        "idDetalle": 1,
        "idEstadia": 1,
        "idServicio": 1,
        "cantidad": 2,
        "subtotal": 31.00
      }
    ]
    ```

### `POST /api/detalle`
- **Descripción**: Agrega un servicio consumido a una estadía específica.
- **Cuerpo de la Petición (`DetalleServicioEstadiaRequestDTO`)**:
  ```json
  {
    "idEstadia": 1,
    "idServicio": 1,
    "cantidad": 2,
    "subtotal": 31.00
  }
  ```
- **Respuestas**:
  - `201 Created`: Detalle agregado correctamente.

### `PUT /api/detalle/{id}`
- **Descripción**: Actualiza un detalle de servicio consumido. Valida que la estadía y el servicio sigan existiendo.
- **Cuerpo de la Petición (`DetalleServicioEstadiaRequestDTO`)**: Igual al de creación.
- **Respuestas**:
  - `200 OK`: Devuelve el detalle actualizado.
  - `400 Bad Request`: Si el detalle, la estadía o el servicio no existen.

### `DELETE /api/detalle/{id}`
- **Descripción**: Elimina un detalle de consumo.
- **Respuestas**:
  - `200 OK`: Eliminado correctamente. Ejemplo de respuesta:
    ```json
    {
      "mensaje": "Detalle eliminado correctamente"
    }
    ```
  - `400 Bad Request`: Si el detalle no existe. Ejemplo de respuesta:
    ```json
    {
      "estado": "400",
      "mensaje": "Detalle de servicio de estadía no encontrado"
    }
    ```

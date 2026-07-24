# Sistema de Gestión Hotelera - Backend 🏨

Bienvenido al repositorio del Backend del Sistema de Gestión Hotelera. Este proyecto proporciona una API RESTful robusta y completa para administrar las operaciones principales de un hotel, incluyendo la gestión de huéspedes, habitaciones, estadías, catálogo de servicios, productos, y el minibar.

---

## 🏗️ Arquitectura y Tecnologías
Este proyecto está construido utilizando **Spring Boot (Java)** y sigue principios de **Arquitectura Limpia (Clean Architecture)** separando las responsabilidades en distintas capas:
- **Capa de Presentación (Controladores y DTOs):** Maneja las peticiones HTTP, mapea los datos de entrada/salida y estandariza las respuestas.
- **Capa de Aplicación (Casos de Uso):** Contiene la lógica de negocio central y las validaciones estrictas de datos.
- **Capa de Dominio (Entidades e Interfaces):** Define los modelos puros y los contratos (puertos) del sistema.
- **Capa de Infraestructura (JPA y Mapeadores):** Se encarga de la persistencia de datos en PostgreSQL utilizando Hibernate y MapStruct para la conversión de objetos.

**Tecnologías Principales:**
- Java 17+
- Spring Boot (Web, Data JPA, Validation)
- PostgreSQL
- MapStruct (Para el mapeo automático entre Entities, Domains y DTOs)
- Lombok

---

## ⚙️ Lógica de Negocio y Flujo del Sistema
El flujo principal de la aplicación garantiza la integridad de los datos mediante validaciones automáticas:
1. **Control de Duplicados:** El sistema bloquea el registro o edición de Huéspedes con la misma cédula, Habitaciones con el mismo número, y Productos/Servicios con el mismo nombre.
2. **Control de Estadías:** Una habitación no puede ser asignada a múltiples estadías al mismo tiempo (control de Overbooking).
3. **Manejo de Transacciones Huerfanas:** Utiliza el patrón DTO para evitar el problema de TransientPropertyValueException de Hibernate al editar relaciones anidadas (ej: Detalles de Servicios).
4. **Respuestas Estandarizadas:** Toda petición exitosa (POST, PUT, DELETE) devuelve un objeto SuccessResponse unificado. Todo error (Validación, Conflicto BD, 404) devuelve un objeto ErrorResponse interceptado por el GlobalExceptionHandler.

---

# Instrucciones de Configuración y Documentación de API

Este documento contiene los pasos necesarios para ejecutar el proyecto, además de la documentación completa de la API con ejemplos de **Postman**, incluyendo las rutas, relaciones, y estructuras de peticiones (requests) y respuestas (responses) en formato JSON.

---

## 1. Configuración para ejecutar el proyecto en otra computadora

Para que el proyecto funcione en cualquier máquina, sigue estos pasos:

### 1.1 Base de Datos (PostgreSQL)
El proyecto utiliza PostgreSQL. Debes crear una base de datos y tener las credenciales correctas en el archivo src/main/resources/application.properties.

- **Nombre de la base de datos:** hotel
- **Puerto de PostgreSQL:** 5432 (Puerto por defecto)
- **Usuario:** postgres
- **Contraseña:** 1234

### 1.2 Puertos y Servidores
El Backend está configurado en el puerto 8081 (puedes cambiarlo si tienes conflictos):
`properties
server.port=8081
`

---

## 2. Documentación de la API (Para Postman)

A continuación, la guía completa de cómo probar cada endpoint en Postman. Para todas las peticiones POST y PUT, asegúrate de ir a la pestaña **Body**, seleccionar **raw** y luego **JSON**.

---

### 3.1 Huéspedes
Gestiona los datos de los clientes del hotel.

**Listar todos los huéspedes:**
- **Tipo:** GET
- **URL:** http://localhost:8081/api/huesped
- **Cuerpo (Body):** *(Ninguno, el ID solo va en la URL, no se envía JSON)*

**Obtener huésped por ID:**
- **Tipo:** GET
- **URL:** http://localhost:8081/api/huesped/1
- **Cuerpo (Body):** *(Ninguno, el ID solo va en la URL, no se envía JSON)*

**Crear un nuevo huésped:**
- **Tipo:** POST
- **URL:** http://localhost:8081/api/huesped
- **Cuerpo (Body) JSON Esperado:**
`json
{
  "nombre": "Cesar",
  "apellido": "Torres",
  "cedula": "1755852081",
  "telefono": "0991234567"
}
`

**Actualizar un huésped:**
- **Tipo:** PUT
- **URL:** http://localhost:8081/api/huesped/1
- **Cuerpo (Body) JSON Esperado:**
`json
{
  "nombre": "Cesar Eduardo"
  "apellido": "Torres"
  "cedula": "1755852081"
  "telefono": "0991234567"
}
`

**Eliminar un huésped:**
- **Tipo:** DELETE
- **URL:** http://localhost:8081/api/huesped/1
- **Cuerpo (Body):** *(Ninguno, el ID solo va en la URL, no se envía JSON)*

**Ejemplo de Respuesta del Servidor (GET / POST / PUT):**
`json
{
  "idHuesped": 1,
  "nombre": "Cesar",
  "apellido": "Torres",
  "cedula": "1755852081",
  "telefono": "0991234567"
}
`

---

### 3.2 Habitaciones
Gestiona las habitaciones del hotel.

**Listar todas las habitaciones:**
- **Tipo:** GET
- **URL:** http://localhost:8081/api/habitacion

**Obtener habitación por ID:**
- **Tipo:** GET
- **URL:** http://localhost:8081/api/habitacion/2

**Crear una nueva habitación:**
- **Tipo:** POST
- **URL:** http://localhost:8081/api/habitacion
- **Cuerpo (Body) JSON Esperado:**
`json
{
  "numero": "205",
  "estado": "OCUPADA",
  "piso": 2,
  "estrellas": 4,
  "capacidad": 4
}
`

**Actualizar una habitación:**
- **Tipo:** PUT
- **URL:** http://localhost:8081/api/habitacion/2
- **Cuerpo (Body) JSON Esperado:**
`json
{
  "numero": "205"
  "estado": "DISPONIBLE"
  "piso": 2
  "estrellas": 4
  "capacidad": 4
}
`

**Filtrar habitaciones por estado:**
- **Tipo:** GET
- **URL:** http://localhost:8081/api/habitacion/buscar?estado=OCUPADA

**Eliminar una habitación:**
- **Tipo:** DELETE
- **URL:** http://localhost:8081/api/habitacion/2

**Ejemplo de Respuesta del Servidor (GET / POST / PUT):**
`json
{
  "idHabitacion": 2,
  "numero": "205",
  "estado": "OCUPADA",
  "piso": 2,
  "estrellas": 4,
  "capacidad": 4
}
`

---

### 3.3 Productos
Productos disponibles para consumo o minibar.

**Listar todos los productos:**
- **Tipo:** GET
- **URL:** http://localhost:8081/api/producto

**Crear un nuevo producto:**
- **Tipo:** POST
- **URL:** http://localhost:8081/api/producto
- **Cuerpo (Body) JSON Esperado:**
`json
{
  "nombre": "Agua Mineral",
  "precio": 1.50,
  "stock": 100
}
`

**Actualizar un producto:**
- **Tipo:** PUT
- **URL:** http://localhost:8081/api/producto/1
- **Cuerpo (Body) JSON Esperado:**
`json
{
  "nombre": "Agua Mineral sin gas"
  "precio": 1.75
  "stock": 80
}
`

**Eliminar un producto:**
- **Tipo:** DELETE
- **URL:** http://localhost:8081/api/producto/1

**Ejemplo de Respuesta del Servidor:**
`json
{
  "idProducto": 1,
  "nombre": "Agua Mineral",
  "precio": 1.50,
  "stock": 100
}
`

---

### 3.4 Catálogo de Servicios
Servicios extra ofrecidos en el hotel.

**Listar catálogo:**
- **Tipo:** GET
- **URL:** http://localhost:8081/api/catalogo

**Crear un nuevo servicio:**
- **Tipo:** POST
- **URL:** http://localhost:8081/api/catalogo
- **Cuerpo (Body) JSON Esperado:**
`json
{
  "nombreServicio": "Masaje Relajante",
  "precio": 45.00
}
`

**Actualizar un servicio:**
- **Tipo:** PUT
- **URL:** http://localhost:8081/api/catalogo/1
- **Cuerpo (Body) JSON Esperado:**
`json
{
  "nombreServicio": "Masaje Relajante Plus"
  "precio": 60.00
}
`

**Eliminar un servicio:**
- **Tipo:** DELETE
- **URL:** http://localhost:8081/api/catalogo/1

**Ejemplo de Respuesta del Servidor:**
`json
{
  "id_servicio": 1,
  "nombreServicio": "Masaje Relajante",
  "precio": 45.00
}
`

---

### 3.5 Estadías
Asigna un Huésped a una Habitación con sus fechas. *(Requiere que el Huésped y la Habitación ya existan).*

**Listar estadías:**
- **Tipo:** GET
- **URL:** http://localhost:8081/api/estadia

**Crear una estadía:**
- **Tipo:** POST
- **URL:** http://localhost:8081/api/estadia
- **Cuerpo (Body) JSON Esperado:**
`json
{
  "idHuesped": 1,
  "idHabitacion": 2,
  "fechaIngreso": "2023-12-01T14:00:00",
  "fechaSalida": "2023-12-05T12:00:00",
  "cantidadHuespedes": 2,
  "totalPagar": 150.00
}
`

**Actualizar una estadía:**
- **Tipo:** PUT
- **URL:** http://localhost:8081/api/estadia/1
- **Cuerpo (Body) JSON Esperado:**
`json
{
  "fechaIngreso": "2023-12-01T14:00:00"
  "fechaSalida": "2023-12-08T12:00:00"
  "cantidadHuespedes": 2
  "totalPagar": 250.00
}
`

**Eliminar una estadía:**
- **Tipo:** DELETE
- **URL:** http://localhost:8081/api/estadia/1

**Ejemplo de Respuesta del Servidor (Incluye las tablas anidadas):**
`json
{
  "idEstadia": 1,
  "huesped": {
    "idHuesped": 1,
    "nombre": "Cesar",
    "apellido": "Torres",
    "cedula": "1755852081",
    "telefono": "0991234567"
  },
  "habitacion": {
    "idHabitacion": 2,
    "numero": "205",
    "estado": "OCUPADA",
    "piso": 2,
    "estrellas": 4,
    "capacidad": 4
  },
  "fechaIngreso": "2023-12-01T14:00:00",
  "fechaSalida": "2023-12-05T12:00:00",
  "cantidadHuespedes": 2,
  "totalPagar": 150.00
}
`

---

### 3.6 Minibar
Asigna productos a una Habitación. *(Requiere que la Habitación y el Producto existan).*

**Listar minibares:**
- **Tipo:** GET
- **URL:** http://localhost:8081/api/minibar

**Asignar producto al minibar (Crear):**
- **Tipo:** POST
- **URL:** http://localhost:8081/api/minibar
- **Cuerpo (Body) JSON Esperado:**
`json
{
  "idHabitacion": 2,
  "idProducto": 1,
  "cantidad": 5
}
`

**Actualizar minibar:**
- **Tipo:** PUT
- **URL:** http://localhost:8081/api/minibar/1
- **Cuerpo (Body) JSON Esperado:**
`json
{
  "idMinibar": 1,
  "idHabitacion": 2,
  "idProducto": 1,
  "cantidad": 10
}
`

**Eliminar producto del minibar:**
- **Tipo:** DELETE
- **URL:** http://localhost:8081/api/minibar/1

**Ejemplo de Respuesta del Servidor:**
`json
{
  "idMinibar": 1,
  "habitacion": {
    "idHabitacion": 2,
    "numero": "205",
    "estado": "OCUPADA",
    "piso": 2,
    "estrellas": 4,
    "capacidad": 4
  },
  "producto": {
    "idProducto": 1,
    "nombre": "Agua Mineral",
    "precio": 1.50,
    "stock": 100
  },
  "cantidad": 5
}
`

---

### 3.7 Detalle de Servicios de Estadía
Registra un servicio (del catálogo) consumido durante una estadía. *(Requiere que la Estadía y el Servicio existan).*

**Listar servicios consumidos:**
- **Tipo:** GET
- **URL:** http://localhost:8081/api/detalle

**Registrar un nuevo consumo (Crear):**
- **Tipo:** POST
- **URL:** http://localhost:8081/api/detalle
- **Cuerpo (Body) JSON Esperado:**
`json
{
  "idEstadia": 1,
  "idServicio": 1,
  "cantidad": 1,
  "subtotal": 45.00
}
`

**Actualizar un consumo:**
- **Tipo:** PUT
- **URL:** http://localhost:8081/api/detalle/1
- **Cuerpo (Body) JSON Esperado:**
`json
{
  "cantidad": 2
  "subtotal": 90.00
}
`

**Eliminar un consumo:**
- **Tipo:** DELETE
- **URL:** http://localhost:8081/api/detalle/1

**Ejemplo de Respuesta del Servidor:**
`json
{
  "idDetalle": 1,
  "estadia": {
    "idEstadia": 1,
    "fechaIngreso": "2023-12-01T14:00:00",
    "totalPagar": 150.00
  },
  "catalogoServicio": {
    "id_servicio": 1,
    "nombreServicio": "Masaje Relajante",
    "precio": 45.00
  },
  "cantidad": 1,
  "subtotal": 45.00
}
`

---

## 4. Validaciones y Manejo de Errores (Error Handling)

El servidor cuenta con un manejador global de excepciones (GlobalExceptionHandler) que captura errores en las peticiones y devuelve un JSON estructurado con el estado HTTP correspondiente, para que el cliente (Frontend o Postman) sepa exactamente qué salió mal.

### 4.1 Error 404 - Recurso No Encontrado (Not Found)
Cuando intentas hacer un **GET, PUT o DELETE** enviando un ID que no existe en la base de datos, el servidor te devolverá un código HTTP 404 con el siguiente JSON:
`json
{
  "status": 404,
  "error": "No Encontrado",
  "message": "Huésped no encontrado",
  "timestamp": "2023-11-20T15:30:00.123"
}
`

### 4.2 Error 400 - Petición Inválida o Mala (Bad Request)
Si envías datos incompletos en un **POST o PUT** (por ejemplo, omites un campo obligatorio que tiene la anotación @Valid), el servidor capturará la validación y devolverá:
`json
{
  "status": 400,
  "error": "Petición Inválida",
  "message": "El nombre no puede estar vacío",
  "timestamp": "2023-11-20T15:31:00.123"
}
`

### 4.3 Error 400 - Conflicto de Datos en BD (Data Integrity Violation)
Si intentas crear un registro que viola una restricción de la base de datos (por ejemplo, ingresar una cédula que ya existe, o borrar una Habitación que actualmente tiene una Estadía asociada), el servidor extraerá la causa exacta y te informará. Por ejemplo, para un registro duplicado:
```json
{
  "status": 400,
  "error": "Conflicto de Datos",
  "message": "La cédula ingresada ya existe. Detalle técnico: ERROR: llave duplicada viola restricción de unicidad «huesped_cedula_key»",
  "timestamp": "2023-11-20T15:32:00.123"
}
```

### 4.4 Error 500 - Error Interno del Servidor (Internal Server Error)
Para cualquier excepción grave no contemplada (problemas de conexión a base de datos, errores nulos no controlados), se captura de forma general para no exponer el código del servidor, devolviendo:
`json
{
  "status": 500,
  "error": "Error del Servidor",
  "message": "Ha ocurrido un error inesperado: (detalle técnico)",
  "timestamp": "2023-11-20T15:33:00.123"
}
`

---

## 5. Estructura de Respuestas Exitosas (Creación, Edición y Eliminación)

Para las peticiones que modifican la base de datos (**POST** para crear, **PUT** para editar y **DELETE** para eliminar), el servidor devolverá una estructura unificada de éxito (similar a la de los errores) que incluye un nuevo parámetro llamado dato con los datos que se enviaron y guardaron.

**Ejemplo de respuesta al crear o editar correctamente:**
`json
{
  "status": 201,
  "message": "Ingreso correcto",
  "timestamp": "2023-11-20T16:00:00.123",
  "dato": {
    "idHuesped": 15,
    "nombre": "Cesar",
    "apellido": "Torres",
    "cedula": "1755852123",
    "telefono": "0991234567"
  }
}
`
*(Nota: el status será 201 para creación y 200 para edición o eliminación, con el mensaje "Ingreso correcto", "Edición correcta" o "Registro borrado exitosamente" respectivamente).*


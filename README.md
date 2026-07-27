# Sistema de Gestión Hotelera - Backend 🏨

Bienvenido al repositorio del Backend del Sistema de Gestión Hotelera. Este proyecto proporciona una API RESTful robusta, segura y completa para administrar las operaciones principales de un hotel, incluyendo la gestión de huéspedes, habitaciones, estadías, catálogo de servicios, productos, y consumos de minibar.

---

## 🏗️ Arquitectura y Tecnologías (Clean Architecture)

Este proyecto está construido utilizando **Spring Boot 3 y Java 21**, siguiendo estrictamente los principios de **Arquitectura Limpia (Clean Architecture / Arquitectura Hexagonal)** y **Clean Code**. La estructura se divide en capas con responsabilidades bien definidas (Single Responsibility Principle - SRP):

- **Capa de Presentación (`presentacion.controladores` y `dto`):** Expone la API RESTful. Los controladores reciben peticiones HTTP, validan la estructura de entrada mediante anotaciones (`@Valid`), delegan la ejecución a los casos de uso y devuelven respuestas DTO estandarizadas (`ResponseEntity`).
- **Capa de Aplicación (`aplicacion.casosuso` y `excepciones`):** Contiene la lógica de negocio pura y la coordinación de procesos (casos de uso). Aquí se aplican reglas de validación, transiciones de estado automáticas y manejo de excepciones personalizadas (`ResourceNotFoundException`, `IllegalArgumentException`).
- **Capa de Dominio (`dominio.entidades` y `repositorios`):** El núcleo del sistema. Define los modelos de negocio puros y las interfaces (puertos) que independizan el negocio de la tecnología de base de datos.
- **Capa de Infraestructura (`infraestructura.persistencia.jpa` y `mappers`):** Implementa los puertos de persistencia utilizando Spring Data JPA / Hibernate sobre PostgreSQL, y emplea MapStruct para la conversión eficiente de entidades JPA a modelos de dominio y DTOs.

### 📦 Dependencias Clave y su Propósito (`pom.xml`):
- **Spring Boot Starter Web:** Proporciona el servidor tomcat embebido y las utilidades para construir endpoints REST.
- **Spring Boot Starter Data JPA:** Facilita la interacción con la base de datos PostgreSQL mediante Hibernate, gestionando transacciones y repositorios.
- **Spring Boot Starter Validation:** Aplica validaciones de reglas de entrada (ej. `@NotNull`, `@Min`, `@NotBlank`) en los DTOs antes de procesar las peticiones.
- **PostgreSQL Driver:** Controlador JDBC para conectar con el motor de base de datos relacional PostgreSQL.
- **MapStruct:** Generador de código en tiempo de compilación para mapear automáticamente entre Entities de JPA, modelos de Dominio y DTOs de Presentación, evitando código boilerplate propenso a errores.
- **Lombok:** Reduce la verbosidad del código Java auto-generando getters, setters, constructores y constructores builder en tiempo de compilación.

---

## ⚙️ Lógica de Negocio y Flujo del Sistema

El flujo del sistema garantiza la consistencia, integridad referencial y automatización de procesos operativos:
1. **Flujo Completo desde Registro hasta Pago de Estadía:**
   - Al registrar una nueva estadía (`POST /api/estadias`), el sistema verifica que el **Huésped** y la **Habitación** existan en base de datos.
   - **Control de Overbooking:** Se verifica dinámicamente que la habitación seleccionada no esté actualmente ocupada en otra estadía activa (cuyo estado no sea `"Pagado"`). Si está ocupada, se rechaza la operación.
   - **Estado por Defecto:** Al iniciar una estadía o registrar un consumo (Minibar/Servicios), el estado se asigna automáticamente como **`"Por Cobrar"`**.
   - **Transición Automática al Liberar Habitación:** Cuando el cliente paga su cuenta (el estado pasa a **`"Pagado"`**), la lógica del caso de uso (`EstadiaUseCaseImpl`) actualiza automáticamente el estado de la habitación en el inventario de **`"Ocupada"`** a **`"Disponible"`**.
2. **Control de Inmutabilidad:** Los consumos y estadías en estado `"Pagado"` quedan bloqueados contra modificaciones e eliminaciones ilegales, preservando la auditoría contable.
3. **Integridad Referencial:** No es posible eliminar un Huésped o Habitación que posea historial de estadías activas.

---

## 🚀 Instrucciones de Configuración y Ejecución

### 1. Requisitos del Entorno
- **JDK 21** instalado y configurado en variable de entorno (`JAVA_HOME`).
- **PostgreSQL** corriendo en el puerto `5433` (configurado en `src/main/resources/application.properties`).

### 2. Configuración de Base de Datos (`application.properties`)
```properties
spring.application.name=hotel
server.port=8081

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.show-sql=true
spring.datasource.url=jdbc:postgresql://localhost:5433/hotel
spring.datasource.username=postgres
spring.datasource.password=1234
```

### 3. Compilación y Ejecución
Para compilar y ejecutar el proyecto sin errores usando el wrapper incluido:
```powershell
# Compilar proyecto y correr pruebas
.\mvnw.cmd clean test-compile

# Ejecutar el servidor embebido en puerto 8081
.\mvnw.cmd spring-boot:run
```

---

## 📡 Documentación Completa de la API REST (Rutas y Peticiones)

La API responde en `http://localhost:8081/api`. Todas las peticiones `POST` y `PUT` requieren el encabezado `Content-Type: application/json`.

### 1. 🏨 Habitaciones (`/api/habitaciones`)
- **GET `/api/habitaciones`**: Lista todas las habitaciones.
- **GET `/api/habitaciones/{id}`**: Obtiene detalles de una habitación por su ID.
- **POST `/api/habitaciones`**: Crea una nueva habitación.
  ```json
  {
    "numero": 205,
    "estado": "Disponible",
    "piso": 2,
    "estrellas": 4,
    "capacidad": 2,
    "precio": 85.50
  }
  ```
- **PUT `/api/habitaciones/{id}`**: Actualiza los datos de la habitación.
- **DELETE `/api/habitaciones/{id}`**: Elimina una habitación (si no tiene estadías en curso).

### 2. 👤 Huéspedes (`/api/huesped`)
- **GET `/api/huesped`**: Lista todos los huéspedes registrados.
- **GET `/api/huesped/{id}`**: Obtiene datos del huésped.
- **POST `/api/huesped`**: Registra un nuevo cliente.
  ```json
  {
    "nombre": "Carlos",
    "apellido": "Mendoza",
    "cedula": "1722334455",
    "telefono": "0998877665",
    "correo": "carlos.m@example.com"
  }
  ```
- **PUT `/api/huesped/{id}`**: Actualiza información del cliente.
- **DELETE `/api/huesped/{id}`**: Elimina al cliente.

### 3. 🛏️ Estadías (`/api/estadia`)
- **GET `/api/estadia`**: Lista el historial de estadías.
- **GET `/api/estadia/{id}`**: Consulta una estadía específica.
- **POST `/api/estadia`**: Registra un ingreso (check-in). Bloquea si la habitación ya está ocupada.
  ```json
  {
    "idHuesped": 1,
    "idHabitacion": 5,
    "fechaIngreso": "2026-07-27T14:00:00",
    "fechaSalida": "2026-07-30T12:00:00",
    "cantidadHuespedes": 2,
    "totalPagar": 256.50,
    "estado": "Por Cobrar"
  }
  ```
- **PUT `/api/estadia/{id}`**: Actualiza fechas, huéspedes o estado (Si pasa a `"Pagado"`, libera la habitación).
- **DELETE `/api/estadia/{id}`**: Elimina el registro de estadía y libera la habitación asociada.

### 4. 🍹 Minibar (`/api/minibar`)
- **GET `/api/minibar`**: Lista todos los cargos de minibar.
- **POST `/api/minibar`**: Registra un nuevo consumo asociado a una habitación.
  ```json
  {
    "idHabitacion": 5,
    "idProducto": 3,
    "cantidad": 2,
    "estado": "Por Cobrar"
  }
  ```
- **PUT `/api/minibar/{id}`**: Edita cantidades de consumo (Bloqueado si estado es `"Pagado"`).
- **DELETE `/api/minibar/{id}`**: Elimina un cargo pendiente.

### 5. 🛎️ Catálogo de Servicios y Detalles (`/api/servicios` y `/api/detalle-estadia`)
- **GET `/api/servicios`**: Lista de servicios adicionales (Lavandería, Spa, Room Service).
- **POST `/api/detalle-estadia`**: Asigna el consumo de un servicio a una estadía en curso.
  ```json
  {
    "idEstadia": 10,
    "idServicio": 2,
    "cantidad": 1,
    "total": 35.00,
    "estado": "Por Cobrar"
  }
  ```

---
*Diseñado por Diego Prieto, Jhoel León y Pablo Torres - Universidad Israel*

# Registro de Cambios y Correcciones

## Capa de Dominio (Entidades)
1. Se renombraron los archivos a formato PascalCase:
   - `estadia.java` -> `Estadia.java`
   - `habitacion.java` -> `Habitacion.java`
   - `huesped.java` -> `Huesped.java`
2. Se aplicó el estándar `camelCase` a todos los atributos de las entidades del dominio para cumplir con las convenciones de Java.
3. Se refactorizaron las entidades usando Lombok (`@Data`) para eliminar el código repetitivo (Getters, Setters, y constructores vacíos) manteniéndolas limpias.

## Capa de Aplicación (Casos de Uso)
1. **Validación de Reglas de Negocio en `EstadiaUseCaseImpl`**:
   - Se añadió lógica de validación para verificar el estado de la habitación antes de guardarla.
   - Si la habitación no existe o su estado es "OCUPADA" u "EN MANTENIMIENTO", se lanza una excepción indicando que no se puede completar la estadía.
   - Esto evita guardar reservas de habitaciones no disponibles.

## Capa de Infraestructura (Persistencia / JPA)
1. **Relaciones JPA en `EstadiaEntity`**:
   - Se cambiaron las propiedades primitivas `id_huesped` e `id_habitacion` por sus verdaderas relaciones orientadas a objetos utilizando las anotaciones `@ManyToOne` y `@JoinColumn`.
   - Se reemplazó:
     - `int id_huesped` -> `@ManyToOne @JoinColumn(name = "id_huesped") HuespedEntity huesped`
     - `int id_habitacion` -> `@ManyToOne @JoinColumn(name = "id_habitacion") HabitacionEntity habitacion`
2. **Corrección de Errores Tipográficos**:
   - Se renombró la clase `DetalleServicoEntity` a `DetalleServicioEntity`.
   - Se actualizaron las referencias de esta entidad en su respectivo repositorio `DetalleServicioEstadiaRepositorioImpl` y su mapper `IDetalleServicioEstadiaJpaMapper`.
3. **Validación de Claves Primarias y Foráneas**:
   - Se comprobó que las entidades cuentan con `@Id` y `@GeneratedValue(strategy = GenerationType.IDENTITY)` de forma correcta.
   - Las relaciones foráneas usan `referencedColumnName` correctamente coincidiendo con las PKs de las otras tablas.

## Capa de Presentación / DTOs
1. **Tipos Primitivos y Nomenclatura**:
   - Los DTOs (Request/Response) fueron actualizados para alinearse al estándar `camelCase` en lugar de `snake_case` (para evitar conflictos de mapeo con MapStruct y cumplir la convención de Java).
   - Se reemplazaron los tipos envoltorio (`Long`, `Integer`, `Double`) por tipos primitivos (`int`, `double`) en todos los DTOs para garantizar mapeo perfecto 1-a-1.
2. **Eliminación de Lombok (`@Data`)**:
   - Para evitar problemas de compilación en entornos donde Lombok no está integrado a nivel de IDE (Eclipse), se eliminaron las anotaciones `@Data` en todas las clases `RequestDTO` y `ResponseDTO`, añadiendo los Getters y Setters de forma explícita a mano.
3. **Manejador Global de Excepciones**:
   - Se creó `ManejadorExcepcionesGlobales.java` usando `@RestControllerAdvice` para capturar `RuntimeException`. Esto permite interceptar errores de la capa de negocio y devolver respuestas HTTP limpias (`400 Bad Request` en formato JSON) en lugar de trazas de error SQL en el servidor (500).

## Validaciones y Reglas de Negocio (Casos de Uso)
1. **Validación de Huésped Existente**:
   - En `HuespedUseCaseImpl`, se agregó la verificación de la cédula mediante `repositorio.buscarPorCedula(cedula)` antes de guardar. Si ya existe, lanza una `RuntimeException` personalizada que es capturada por el Manejador Global.
   - Para esto, se implementó correctamente `findByCedula` en el repositorio JPA `IHuespedJpaRepositorio`.
2. **Validación al Eliminar**:
   - Se añadió lógica a todos los Casos de Uso (`Huesped`, `Habitacion`, `Estadia`, `Catalogo`, `Detalle`) en sus respectivos métodos de eliminación (`eliminar(id)`).
   - Ahora verifican la existencia del dato a borrar mediante `buscarPorId`. Si no existe, lanzan excepción (`"Dato no encontrado"`), y si existe, completan la eliminación y devuelven un JSON de éxito (Http Status 200).

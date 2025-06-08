# Timebank

Microservicio para gestionar un banco del tiempo. Construido con Spring Boot, arquitectura hexagonal, Lombok y MapStruct. Todo el código se organiza bajo el paquete base `es.doterorgz.timebank` y los artefactos Maven comparten el mismo `groupId`.

El proyecto se organiza en varios módulos Maven:

- **domain**: entidades de negocio e interfaces de servicios.
- **application**: (reservado para casos de uso, actualmente sin código).
- **adapters**: persistencia y servicios de infraestructura.
- **api-rest**: controladores REST y mapeadores MapStruct.
- **boot**: aplicación Spring Boot que arranca el microservicio.

## Compilación

Este proyecto utiliza Maven. Para compilar y ejecutar las pruebas:

```bash
mvn clean test
```

## Ejecución

```bash
mvn -pl boot spring-boot:run
```

La API REST estará disponible en `http://localhost:8080`.

Endpoints destacados de actividades:

- `POST /activities` crea una actividad.
- `GET /activities` lista todas las actividades.
- `GET /activities/location?lat=<lat>&lon=<lon>&distance=<d>` busca por ubicación y distancia.
- `GET /activities/search?text=<texto>` busca por texto en título o descripción.
- `GET /activities/dates?start=<iso>&end=<iso>` filtra por rango de fechas.
- `GET /activities/filter?...` combina todos los criterios anteriores.

La configuración de Spring se encuentra en `boot/src/main/resources/application.yml`.

## Base de datos

El servicio utiliza PostgreSQL como base de datos. Los valores de conexión por defecto son:

```
url: jdbc:postgresql://localhost:5432/timebank
usuario: postgres
contraseña: postgres
```

Antes de arrancar la aplicación, asegúrate de que existe una instancia de PostgreSQL con esa base de datos creada. Para facilitarlo se incluye un `docker-compose.yml` que lanza un contenedor con dichas credenciales:

```bash
docker-compose up -d
```

Después puedes ejecutar la aplicación normalmente con:

```bash
mvn -pl boot spring-boot:run
```

## Base de datos

El servicio utiliza PostgreSQL como base de datos. Los valores de conexión por defecto son:

```
url: jdbc:postgresql://localhost:5432/timebank
usuario: postgres
contraseña: postgres
```

Antes de arrancar la aplicación, asegúrate de que existe una instancia de PostgreSQL con esa base de datos creada. Para facilitarlo se incluye un `docker-compose.yml` que lanza un contenedor con dichas credenciales:

```bash
docker-compose up -d
```

Después puedes ejecutar la aplicación normalmente con:

```bash
mvn -pl boot spring-boot:run
```

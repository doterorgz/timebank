# Timebank

Microservicio para gestionar un banco del tiempo. Construido con Spring Boot, arquitectura hexagonal, Lombok y MapStruct. Todo el código se organiza bajo el paquete base `es.doterorgz.timebank` y los artefactos Maven comparten el mismo `groupId`.

El proyecto se organiza en varios módulos Maven:

- **domain**: entidades de negocio.
- **application**: servicios y DTOs.
- **adapters**: REST, persistencia y aplicación Spring Boot.

## Compilación

Este proyecto utiliza Maven. Para compilar y ejecutar las pruebas:

```bash
mvn clean test
```

## Ejecución

```bash
mvn -pl adapters spring-boot:run
```

La API REST estará disponible en `http://localhost:8080`.

La configuración de Spring se encuentra en `adapters/src/main/resources/application.yml`.

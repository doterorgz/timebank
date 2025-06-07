# Timebank

Microservicio para gestionar un banco del tiempo. Construido con Spring Boot, arquitectura hexagonal, Lombok y MapStruct.

## Compilación

Este proyecto utiliza Maven. Para compilar y ejecutar las pruebas:

```bash
mvn clean test
```

## Ejecución

```bash
mvn spring-boot:run
```

La API REST estará disponible en `http://localhost:8080`.

La configuración de Spring se encuentra en `src/main/resources/application.yml`.

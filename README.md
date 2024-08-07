# Universidad Backend

Este es un backend para gestionar una universidad, desarrollado con Spring Boot. El proyecto proporciona APIs para manejar alumnos, profesores, carreras y otras entidades asociadas, utilizando MapStruct para el mapeo entre entidades y DTOs.

## Características

- **Gestión de Alumnos**: CRUD para alumnos, incluyendo búsqueda por nombre de carrera.
- **Gestión de Profesores**: CRUD para profesores.
- **Gestión de Carreras**: CRUD y búsqueda avanzada para carreras.
- **Mapeo con MapStruct**: Conversión entre entidades y DTOs para una fácil transferencia de datos.

## Tecnologías

- **Spring Boot**: Para el desarrollo de la aplicación.
- **MapStruct**: Para el mapeo entre entidades y DTOs.
- **JPA/Hibernate**: Para la persistencia de datos en la base de datos.

## Estructura del Proyecto

- **Controladores**: Manejan las solicitudes HTTP.
- **DTOs**: Objetos de transferencia de datos para comunicación entre la capa de presentación y la capa de servicio.
- **Entidades**: Clases que representan las tablas en la base de datos.
- **Repositorios**: Interfaces para la interacción con la base de datos.
- **DAOs e Implementaciones**: Interfaces y clases para la lógica de negocio.
- **Mappers**: Convertidores entre entidades y DTOs.

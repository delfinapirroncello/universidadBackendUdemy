package com.springudemy.universidad.universidadbackend.servicios.contratos;

import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaDAO extends GenericoDAO<Persona> {
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);

    Optional<Persona> buscarPorDni(String dni);

    Iterable<Persona> buscarPersonasPorApellido(String apellido);

    Iterable<Persona> findAll();
}

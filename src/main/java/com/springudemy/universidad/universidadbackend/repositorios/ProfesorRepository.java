package com.springudemy.universidad.universidadbackend.repositorios;

import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioProfesores")
public interface ProfesorRepository extends PersonaRepository {

    @Query("select p from Profesor p join fetch p.carreras c where c.nombre = ?1")
    Iterable<Persona> findProfesoresByCarrera(String carrera);

}

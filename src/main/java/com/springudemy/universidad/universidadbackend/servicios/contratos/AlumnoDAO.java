package com.springudemy.universidad.universidadbackend.servicios.contratos;

import com.springudemy.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoDAO extends CrudRepository<Alumno, Long> {

    Iterable<Alumno> findAllAlumnos();
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);
}

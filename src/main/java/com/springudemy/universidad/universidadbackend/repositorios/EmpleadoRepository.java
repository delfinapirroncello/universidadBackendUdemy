package com.springudemy.universidad.universidadbackend.repositorios;


import com.springudemy.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Empleado;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import com.springudemy.universidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;
import com.springudemy.universidad.universidadbackend.servicios.contratos.EmpleadoDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("repositorioEmpleados")
public interface EmpleadoRepository extends PersonaRepository {
    @Query("select e from Empleado e where e.tipoEmpleado = ?1")
    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);
}
package com.springudemy.universidad.universidadbackend.repositorios;

import aj.org.objectweb.asm.Opcodes;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Pabellon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository("repositorioPabellon")
public interface PabellonRepository extends CrudRepository<Pabellon, Integer> {

    Iterable<Pabellon> findPabellonByDireccion_Localidad(String localidad);
    Optional<Pabellon> findPabellonByNombreIgnoreCase(String nombre);
    Iterable<Pabellon> findPabellonByFechaAltaBetween(LocalDateTime desde, LocalDateTime hasta);
}

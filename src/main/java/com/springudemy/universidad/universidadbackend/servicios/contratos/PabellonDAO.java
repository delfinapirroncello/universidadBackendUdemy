package com.springudemy.universidad.universidadbackend.servicios.contratos;

import com.springudemy.universidad.universidadbackend.modelo.entidades.Pabellon;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PabellonDAO extends GenericoDAO<Pabellon> {

    Iterable<Pabellon> buscarPabellonPorLocalidad(String localidad);
    Optional<Pabellon> findPabellonByNombreIgnoreCase(String nombre);
    Iterable<Pabellon> findPabellonByFechaAltaBetween(LocalDateTime desde, LocalDateTime hasta);
}

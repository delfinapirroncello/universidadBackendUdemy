package com.springudemy.universidad.universidadbackend.servicios.contratos;

import com.springudemy.universidad.universidadbackend.modelo.entidades.Carrera;

public interface CarreraDAO extends GenericoDAO<Carrera>{
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
}

package com.springudemy.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springudemy.universidad.universidadbackend.modelo.dto.AlumnoDTO;
import com.springudemy.universidad.universidadbackend.modelo.dto.ProfesorDTO;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Profesor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = AlumnoMapperConfig.class)
public abstract class ProfesorMapper {

    public abstract ProfesorDTO mapProfesor(Profesor profesor);
    public abstract Profesor mapProfesor(ProfesorDTO profesorDTO);
}
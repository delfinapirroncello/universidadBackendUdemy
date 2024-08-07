package com.springudemy.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springudemy.universidad.universidadbackend.modelo.dto.AlumnoDTO;
import com.springudemy.universidad.universidadbackend.modelo.dto.ProfesorDTO;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Profesor;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface AlumnoMapperConfig extends PersonaMapperConfig{

    @InheritConfiguration(name = "mapPersona")
    void mapAlumno (Alumno alumno, @MappingTarget AlumnoDTO alumnoDTO);

}

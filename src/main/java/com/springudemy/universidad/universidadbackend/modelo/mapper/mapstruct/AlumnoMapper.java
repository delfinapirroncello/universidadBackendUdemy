package com.springudemy.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springudemy.universidad.universidadbackend.modelo.dto.AlumnoDTO;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Alumno;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", config = AlumnoMapperConfig.class)
public abstract class AlumnoMapper {

    public abstract AlumnoDTO mapAlumno(Alumno alumno);
    public abstract Alumno mapAlumno(AlumnoDTO alumnoDTO);

}

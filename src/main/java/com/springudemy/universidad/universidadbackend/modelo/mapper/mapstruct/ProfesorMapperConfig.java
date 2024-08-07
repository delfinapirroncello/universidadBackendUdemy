package com.springudemy.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springudemy.universidad.universidadbackend.modelo.dto.ProfesorDTO;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Profesor;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface ProfesorMapperConfig extends PersonaMapperConfig{

    @InheritConfiguration(name = "mapPersona")
    void mapProfesor(Profesor profesor, @MappingTarget ProfesorDTO profesorDTO);

}

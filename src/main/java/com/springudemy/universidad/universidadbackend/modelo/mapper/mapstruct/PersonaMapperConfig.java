package com.springudemy.universidad.universidadbackend.modelo.mapper.mapstruct;

import com.springudemy.universidad.universidadbackend.modelo.dto.PersonaDTO;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface PersonaMapperConfig {

    void mapPersona(Persona persona, @MappingTarget PersonaDTO personaDTO);

}

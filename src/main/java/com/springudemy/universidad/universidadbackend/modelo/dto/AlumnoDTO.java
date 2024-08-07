package com.springudemy.universidad.universidadbackend.modelo.dto;

import com.springudemy.universidad.universidadbackend.modelo.entidades.Direccion;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@NoArgsConstructor
public class AlumnoDTO extends PersonaDTO {

    public AlumnoDTO(Integer id, String nombre, String apellido, String dni, Direccion direccion) {
        super(id, nombre, apellido, dni, direccion);
    }

}


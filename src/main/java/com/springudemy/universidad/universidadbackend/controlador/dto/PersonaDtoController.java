package com.springudemy.universidad.universidadbackend.controlador.dto;

import com.springudemy.universidad.universidadbackend.modelo.dto.PersonaDTO;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Empleado;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Profesor;
import com.springudemy.universidad.universidadbackend.modelo.mapper.mapstruct.AlumnoMapper;
import com.springudemy.universidad.universidadbackend.modelo.mapper.mapstruct.ProfesorMapper;
import com.springudemy.universidad.universidadbackend.servicios.contratos.PersonaDAO;

public class PersonaDtoController extends GenericDtoController<Persona, PersonaDAO> {

    protected final AlumnoMapper alumnoMapper;
    protected final ProfesorMapper profesorMapper;

    public PersonaDtoController(PersonaDAO service, String nombre_entidad, AlumnoMapper alumnoMapper, ProfesorMapper profesorMapper) {
        super(service, nombre_entidad);
        this.alumnoMapper = alumnoMapper;
        this.profesorMapper = profesorMapper;
    }


    public PersonaDTO altaPersona(Persona persona){
        Persona personaEntidad = super.altaEntidad(persona);
        PersonaDTO dto = null;
        if (personaEntidad instanceof Alumno){
            dto = alumnoMapper.mapAlumno((Alumno) personaEntidad);
        } else if (personaEntidad instanceof Profesor){
            //aplicariamos mapper de profesor

        } else if (personaEntidad instanceof Empleado) {
            //aplicamos el mapper de empleado
        }
        return dto;
    }
}

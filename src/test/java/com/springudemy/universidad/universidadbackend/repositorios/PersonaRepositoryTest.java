package com.springudemy.universidad.universidadbackend.repositorios;

import com.springudemy.universidad.universidadbackend.datos.DatosDummy;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Empleado;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Profesor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.springudemy.universidad.universidadbackend.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonaRepositoryTest {


    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepository;
    @Autowired
    @Qualifier("repositorioEmpleados")
    PersonaRepository empleadoRepository;
    @Autowired
    @Qualifier("repositorioProfesores")
    PersonaRepository profesorRepository;

    @Test
    void buscarPorNombreYApellido() {
        //given
        Persona save = empleadoRepository.save(DatosDummy.empleado01());

        //when
        Optional<Persona> expected = empleadoRepository.buscarPorNombreYApellido(DatosDummy.empleado01().getNombre(),
                DatosDummy.empleado01().getApellido());

        //then
        assertThat(expected.get()).isInstanceOf(Empleado.class);
        assertThat(expected.get()).isEqualTo(save);
    }

    @Test
    void buscarPorDni() {

        //given
        Persona save = profesorRepository.save(profesor01());

        //when
        Optional<Persona> expected = profesorRepository.buscarPorDni(profesor01().getDni());

        //then
        assertThat(expected.get()).isInstanceOf(Profesor.class);
        assertThat(expected.get()).isEqualTo(save);
        assertThat(expected.get().getDni()).isEqualTo(save.getDni());
    }

    @Test
    void buscarPersonasPorApellido() {

        //given
        Iterable<Persona> personas = alumnoRepository.saveAll(
                Arrays.asList(
                        alumno01(),
                        alumno02(),
                        alumno03())
        );

        //when
        String apellido = "Benediz";
        List<Persona> expected = (List<Persona>) alumnoRepository.buscarPersonasPorApellido(apellido);

        //then
        assertThat(expected.size() == 2).isTrue();

    }
}
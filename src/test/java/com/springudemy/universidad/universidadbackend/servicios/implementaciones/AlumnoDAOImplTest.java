package com.springudemy.universidad.universidadbackend.servicios.implementaciones;

import com.springudemy.universidad.universidadbackend.repositorios.AlumnoRepository;
import com.springudemy.universidad.universidadbackend.servicios.contratos.AlumnoDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class AlumnoDAOImplTest {

    @MockBean
    AlumnoRepository alumnoRepository;
    @Autowired
    AlumnoDAO alumnoDAO;

    @Test
    void buscarAlumnosPorNombreCarrera() {
        //when
        alumnoDAO.buscarAlumnosPorNombreCarrera(anyString());

        //then
        verify(alumnoRepository).buscarAlumnosPorNombreCarrera(anyString());
    }
}
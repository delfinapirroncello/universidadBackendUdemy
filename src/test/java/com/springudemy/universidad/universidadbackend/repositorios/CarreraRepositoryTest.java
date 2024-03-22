package com.springudemy.universidad.universidadbackend.repositorios;

import com.springudemy.universidad.universidadbackend.datos.DatosDummy;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Carrera;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CarreraRepositoryTest {

    @Autowired
    CarreraRepository carreraRepository;

    @BeforeEach
    void setUp() {
        carreraRepository.save(DatosDummy.carrera01(false));
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03(false));
    }

    @AfterEach
    void tearDown() {
        carreraRepository.deleteAll();
    }

    @Test
    @DisplayName("Buscar Carreras por nombre")
    void findCarrerasByNombreContains() {
        /*given
        carreraRepository.save(DatosDummy.carrera01());
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03());*/

        //when
        Iterable<Carrera> expected = carreraRepository.findCarrerasByNombreContains("Sistemas");

        //then
        int count = 0;
        for (Carrera carrera : expected) {
            count++;
        }
        assertThat(count).isEqualTo(2);
    }


    @Test
    @DisplayName("Buscar Carreras por nombre NO case sensitive")
    void findCarrerasByNombreContainsIgnoreCase() {
        /*given
        carreraRepository.save(DatosDummy.carrera01());
        carreraRepository.save(DatosDummy.carrera03());
        carreraRepository.save(DatosDummy.carrera02());*/

        //when
        java.util.List<Carrera> expected = (java.util.List<Carrera>) carreraRepository.findCarrerasByNombreContainsIgnoreCase("sistemas");

        //then
        assertThat(expected.size() == 2).isTrue();
    }

    @Test
    @DisplayName("Buscar Carreras mayor a N años")
    void findCarrerasByCantidadAniosAfter() {

        /*given
        carreraRepository.save(DatosDummy.carrera01());
        carreraRepository.save(DatosDummy.carrera03());
        carreraRepository.save(DatosDummy.carrera02());*/

        //when
        java.util.List<Carrera> expected = (java.util.List<Carrera>) carreraRepository.findCarrerasByCantidadAniosAfter(4);

        //then
        assertThat(expected.size() == 3).isTrue();
    }
}
package com.springudemy.universidad.universidadbackend.repositorios;

import com.springudemy.universidad.universidadbackend.datos.DatosDummy;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Aula;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Pabellon;
import com.springudemy.universidad.universidadbackend.modelo.entidades.enumeradores.Pizarron;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AulaRepositoryTest {

    @Autowired
    AulaRepository aulaRepository;
    @Autowired
    PabellonRepository pabellonRepository;

    @Test
    void findAulasByPizarron() {
        //given
        Aula save = aulaRepository.save(DatosDummy.getAula123());

        //when
        String tipoPizarron = "PIZARRA_BLANCA";
        List<Aula> expected = (List<Aula>) ((AulaRepository) aulaRepository).findAulasByPizarron(Pizarron.valueOf(tipoPizarron));

        //then
        assertThat(expected.iterator().next().getPizarron()).isEqualTo(save.getPizarron());
    }

    @Test
    void findAulaByNroAula() {
        //given
        Aula save = aulaRepository.save(DatosDummy.getAula123());

        //when
        Optional<Aula> expected = aulaRepository.findAulaByNroAula(DatosDummy.getAula123().getNroAula());

        //then
        assertThat(expected.get()).isInstanceOf(Aula.class);
        assertThat(expected.get()).isEqualTo(save);
    }
}
package com.springudemy.universidad.universidadbackend;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class UniversidadBackendApplicationTests {

	Calculadora calculadora = new Calculadora();

	@Test
	@DisplayName("Suma de valor A y valor B")
	void sumaDeValores() {
		// given -> armado del contexto de lo que vamos a necesitar
		int valorA = 2;
		int valorB = 3;

		// when -> va a significar la accion que queremos hacer o que vamos a realizar
		int expectativa = calculadora.sumar(valorA, valorB);

		// then -> resultado que queremos obtener-comprobar lo esperado
		int resultadoEsperado = 5;
		assertThat(expectativa).isEqualTo(resultadoEsperado);
	}

    @Test
	@DisplayName("Test deprecado")
    @Disabled("Test deprecado")
    void testDesactivado() {

    }

    class Calculadora{
		int sumar(int valor_a, int valor_b){
			return valor_a + valor_b;
		}
	}

}

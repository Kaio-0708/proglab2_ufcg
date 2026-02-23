package Agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PalestraTest {

	private Palestra palestra;
	
	@BeforeEach
	void setUp() {
		palestra = new Palestra("Java", "Teste de Java", "07/08/2001", 10);
	}

	@Test
	void validarCalculoPontuacao() {
		int valor = palestra.calcularPontuacao();
		
		assertEquals(2, valor);
	}
}

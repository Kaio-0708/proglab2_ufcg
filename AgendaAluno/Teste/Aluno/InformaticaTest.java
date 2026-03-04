package Aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InformaticaTest {

	private Informatica informatica;
	
	@BeforeEach
	void setUp() {
		informatica = new Informatica("Robotica", "robotica com IA", "0000", 10, 20);
	}
	
	@Test
	void calcularPontuacao() {
		int resultado = informatica.calcularPontuacao();
		
		assertEquals(20, resultado);
	}
	
	@Test
	void naoCalcularPontuacao() {
		int resultado = informatica.calcularPontuacao();
		
		assertNotEquals(10, resultado);
	}
}

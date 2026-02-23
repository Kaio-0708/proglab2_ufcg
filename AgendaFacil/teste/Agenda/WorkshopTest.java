package Agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WorkshopTest {

	private Workshop workshop;
	
	@BeforeEach
	void setUp() {
		workshop = new Workshop("Java", "Teste de Java", "07/08/2001", 10, 10);
	}
	
	@Test
	void validarCalculoPontuacao() {
		int resultado = workshop.calcularPontuacao();
		
		assertEquals(10, resultado);
	}
}

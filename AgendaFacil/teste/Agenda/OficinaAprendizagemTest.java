package Agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OficinaAprendizagemTest {

	private OficinaAprendizagem oficina;
	
	@BeforeEach
	void setUp() {
		oficina = new OficinaAprendizagem("Java", "Teste de Java", "07/08/2001", 10, 10, false);
	}
	
	@Test
	void validarCalculoPontuacaoSemCertificado() {
		int result = oficina.calcularPontuacao();
		
		assertEquals(10, result);
	}
	
	@Test
	void validarCalculoPontuacaoComCertificado() {
		oficina = new OficinaAprendizagem("Java", "Teste de Java", "07/08/2001", 10, 10, true);
		
		int result = oficina.calcularPontuacao();
		
		assertEquals(20, result);
	}
}
	

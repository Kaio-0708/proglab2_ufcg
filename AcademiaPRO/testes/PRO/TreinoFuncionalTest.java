package PRO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreinoFuncionalTest {

	private TreinoFuncional treinoF;
	
	@BeforeEach
	void setUp() {
		treinoF = new TreinoFuncional("jose", 2, 5, 100);
	}
	
	@Test
	void validarCalcularPontuacao() {
		int resultado = treinoF.calcularPontos();
	
		assertEquals(10, resultado);
	}
	
	@Test
	void naoValidarCalcularPontuacao() {
		int resultado = treinoF.calcularPontos();
	
		assertNotEquals(20, resultado);
	}
}

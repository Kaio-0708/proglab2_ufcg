package PRO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreinoCardioTest {

	private TreinoCardio treinoC;
	
	@BeforeEach
	void setUp() {
		treinoC = new TreinoCardio("jose", 2, 5);
	}
	
	@Test
	void validarCalcularPontuacao() {
		int resultado = treinoC.calcularPontos();
		
		assertEquals(5, resultado);
	}
	
	@Test
	void naoValidarCalcularPontuacao() {
		int resultadoErrado = treinoC.calcularPontos();
		
		assertNotEquals(10, resultadoErrado);
	}
}

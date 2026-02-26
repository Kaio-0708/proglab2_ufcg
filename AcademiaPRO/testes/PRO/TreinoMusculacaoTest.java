package PRO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreinoMusculacaoTest {

	private TreinoMusculacao treinoM;
	
	@BeforeEach
	void setUp() {
		treinoM = new TreinoMusculacao("jose", 2, 5, 100);
	}
	
	@Test
	void validarCalcularPontuacao() {
		int resultado = treinoM.calcularPontos();
		
		assertEquals(100, resultado);
	}
	
	@Test
	void naoValidarCalcularPontuacao() {
		int resultadoErrado = treinoM.calcularPontos();
		
		assertNotEquals(10, resultadoErrado);
	}
}

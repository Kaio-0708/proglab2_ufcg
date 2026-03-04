package BD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DidaticoTest {

	private Didatico didatico;
	
	@BeforeEach
	void setUp() {
		didatico = new Didatico("Amor", "História de amor", "07082001", 10, 20, true);
	}

	@Test
	void verificarPontuacaoPontoExtra() {
		int verificar = didatico.gerarPontos();
		
		assertEquals(25, verificar);
	}
	
	@Test
	void errarVerificarPontuacaoPontoExtra() {
		int verificar = didatico.gerarPontos();
		
		assertNotEquals(22, verificar);
	}
	
	@Test
	void verificarPontuacaoSemPontoExtra() {
		didatico = new Didatico("Amor", "História de amor", "07082001", 10, 20, false);
		
		int verificar = didatico.gerarPontos();
		
		assertEquals(20, verificar);
	}
	
	@Test
	void errarVerificarPontuacaoSemPontoExtra() {
		didatico = new Didatico("Amor", "História de amor", "07082001", 10, 20, false);
		
		int verificar = didatico.gerarPontos();
		
		assertNotEquals(21, verificar);
	}
}

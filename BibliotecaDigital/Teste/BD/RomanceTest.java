package BD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RomanceTest {

	private Romance romance;
	
	@BeforeEach
	void setUp() {
		romance = new Romance("Amor", "História de amor", "07082001", 10);
	}
	
	@Test
	void verificarPontuacao() {
		int verificar = romance.gerarPontos();
		
		assertEquals(2, verificar);
	}
	
	@Test
	void naoVerificarPontuacao() {
		int verificar = romance.gerarPontos();
		
		assertNotEquals(2, verificar);
	}
}

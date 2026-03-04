package BD;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CientificoTest {

	private Cientifico c;
	
	@BeforeEach
	void setUp() {
		c = new Cientifico("Amor", "História de amor", "07082001", 10, 10);
	}
	
	@Test
	void verificarPontos() {
		int verificar = c.gerarPontos();
		
		assertEquals(10, verificar);
	}
	
	@Test
	void naoVerificarPontos() {
		int verificar = c.gerarPontos();
		
		assertNotEquals(11, verificar);
	}
}


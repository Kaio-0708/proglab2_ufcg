package Academia;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreinoTest {

	private Treino treino;
	
	@BeforeEach
	void setUp() {
		treino = new Treino("Força", "Maior força", "24/02/2006", 10);
	}

	@Test
	void CalcularPontuacao() {
		int result = treino.calcularPontuacao();
		
		assertEquals(2, result);
	}

}

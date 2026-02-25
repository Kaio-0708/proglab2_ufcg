package Academia;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CampeonatoTest {

	private Campeonato campeonato;
	
	@BeforeEach
	void setUp() {
		campeonato = new Campeonato("Força", "Maior força", "24/02/2006", 10, 20);
	}

	@Test
	void CalcularPontuacao() {
		int result = campeonato.calcularPontuacao();
		
		assertEquals(20, result);
	}
}

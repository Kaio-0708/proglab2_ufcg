package RB;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReparoTest {

	private Reparo reparo;
	
	@BeforeEach
	void prepararReajuste() {
		reparo = new Reparo("1", "barra", 20.0);
	}
	
	@Test
	void deveReajustarPrecoReparo() {
		reparo.reajustarPercentual(10);
		assertEquals(22, reparo.getPreco());
	}
	
	@Test
	void deveReajustarParamenosPrecoReparo() {
		reparo.reajustarPercentual(-10);
		assertEquals(18, reparo.getPreco());
	}

}

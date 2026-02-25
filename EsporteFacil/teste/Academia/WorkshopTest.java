package Academia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WorkshopTest {

	private Workshop workshop;
	
	@BeforeEach
	void setUp() {
		workshop = new Workshop("Força", "Maior força", "24/02/2006", 10, 20, true);
	}
	
	@Test
	void calcularPontuacaoComCertificado() {
		int result = workshop.calcularPontuacao();
		
		assertEquals(30, result);
	}
	
	@Test
	void calcularPontuacaoSemCertificado() {
		workshop = new Workshop("Força", "Maior força", "24/02/2006", 10, 20, false);
		
		int result = workshop.calcularPontuacao();
		
		assertEquals(20, result);
	}
}

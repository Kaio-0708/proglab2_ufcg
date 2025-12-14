package escrevedeira;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClubeDeLeituraTest {

	@Test
	void testReajustarValorClube() {
		ClubesDeLeitura clube = new ClubesDeLeitura(
				"Clássicos",
                "Grande Sertão: Veredas",
                "Guimarães Rosa",
                "12/10/2024",
                "8h",
                "Meet",
                "Ryan",
                25.0
                );
		
		clube.setValor(30.0);
		assertEquals(30.0, clube.getValor());
	}
	
	@Test
	void testNaoReajustarValorClube() {
		ClubesDeLeitura clube = new ClubesDeLeitura(
				"Clássicos",
                "Grande Sertão: Veredas",
                "Guimarães Rosa",
                "12/10/2024",
                "8h",
                "Meet",
                "Ryan",
                25.0
                );
		
		clube.setValor(25.0);
		assertEquals(25.0, clube.getValor());
	}
}

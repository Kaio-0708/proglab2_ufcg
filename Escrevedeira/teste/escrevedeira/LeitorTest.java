package escrevedeira;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LeitorTest {

	@Test
	void testIncluirLivroPreferido() {
		Leitor leitor = new Leitor("Vitu", "vitu@gmail.com");
		
		ClubesDeLeitura clube = new ClubesDeLeitura(
				"Clássicos",
                "Dom Casmurro",
                "Machado de Assis",
                "10/10/2024",
                "18h",
                "Meet",
                "Carlos",
                20.0);
		
		leitor.adicionarClube(clube);
		boolean resultado = leitor.adicionarFavorito("Dom Casmurro");
		assertTrue(resultado);
	}
	
	@Test
	void testNaoIncluirLivroPreferido() {
		Leitor leitor = new Leitor("Vitu", "vitu@gmail.com");
		
		boolean resultado = leitor.adicionarFavorito("Dom Casmurro");
		assertFalse(resultado);
	}
	
}

package BD;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BibliotecaDigitalControllerTest {

	private BibliotecaDigitalController biblioteca;
	
	@BeforeEach()
	void setUp() {
		biblioteca = new BibliotecaDigitalController();
	}	
	
	@Test
	void rankingLeitoresPontos() {
		biblioteca.cadastrarLeitor("Kaio", "kaio@gmail.com");
		biblioteca.cadastrarLeitor("Vitor", "vitor@gmail.com");
		biblioteca.cadastrarLeitor("Santos", "Santos@gmail.com");
		
		int id1 = biblioteca.cadastrarRomance("Amor", "História de amor", "07082001", 10);
		int id2 = biblioteca.cadastrarDidatico("Amor", "História de amor", "07082001", 10, 20, true);
		int id3 = biblioteca.cadastrarCientifico("Amor", "História de amor", "07082001", 10, 10);
		
		biblioteca.emprestarLivro("kaio@gmail.com", id2);
		biblioteca.emprestarLivro("vitor@gmail.com", id3);
		biblioteca.emprestarLivro("Santos@gmail.com", id1);
		
		String[] ranking = biblioteca.listarLeitores();
		
		assertEquals("Kaio", ranking[0]);
		assertEquals("Vitor", ranking[1]);
		assertEquals("Santos", ranking[2]);
	}
	
	@Test
	void rankingLeitoresNome() {
		biblioteca.cadastrarLeitor("Kaio", "kaio@gmail.com");
		biblioteca.cadastrarLeitor("Vitor", "vitor@gmail.com");
		biblioteca.cadastrarLeitor("Santos", "Santos@gmail.com");
		
		String[] ranking = biblioteca.listarLeitores();
		
		assertEquals("Kaio", ranking[0]);
		assertEquals("Vitor", ranking[2]);
		assertEquals("Santos", ranking[1]);
	}
	
	@Test
	void rankingLeitorSemLeitor() {
		String[] ranking = biblioteca.listarLeitores();
		
		assertEquals(0, ranking.length);
	}
	
	@Test
	void rankingApenasUmLeitorNome() {
		biblioteca.cadastrarLeitor("Kaio", "kaio@gmail.com");
		
		String[] ranking = biblioteca.listarLeitores();
		
		assertEquals("Kaio", ranking[0]);
	}
}

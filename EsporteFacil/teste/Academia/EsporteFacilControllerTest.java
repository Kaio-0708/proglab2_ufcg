package Academia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EsporteFacilControllerTest {

	private EsporteFacilController esporte;
	
	@BeforeEach
	void setUp() {
		esporte = new EsporteFacilController();
	}
	
	@Test
	void listarAtletaPorOrdemDescrecente() {
		esporte.cadastrarAtleta("Kaio", "kaio@gmail.com");
		esporte.cadastrarAtleta("Vitor", "vitor@gmail.com");
		
		int id1 = esporte.cadastrarCampeonato("Codar", "Velocidade de codar", "24/02/2026", 10, 10);
		int id2 = esporte.cadastrarCampeonato("Codar", "Velocidade de codar", "24/02/2026", 10, 20);
		
		esporte.inscreverAtletaEmAtividade("kaio@gmail.com", id2);
		esporte.inscreverAtletaEmAtividade("vitor@gmail.com", id1);
		
		String[] resultado = esporte.listarAtletas();
		
		assertEquals("Kaio", resultado[0]);
		assertEquals("Vitor", resultado[1]);
	}
	
	@Test
	void listarMultiplosAtletaPorOrdemDescrecente() {
		esporte.cadastrarAtleta("Kaio", "kaio@gmail.com");
		esporte.cadastrarAtleta("Vitor", "vitor@gmail.com");
		esporte.cadastrarAtleta("Livia", "livia@gmail.com");
		esporte.cadastrarAtleta("Melina", "melina@gmail.com");
		
		int id1 = esporte.cadastrarCampeonato("Codar", "Velocidade de codar", "24/02/2026", 10, 10);
		int id2 = esporte.cadastrarCampeonato("Codar", "Velocidade de codar", "24/02/2026", 10, 20);
		int id3 = esporte.cadastrarCampeonato("Codar", "Velocidade de codar", "24/02/2026", 10, 30);
		int id4 = esporte.cadastrarCampeonato("Codar", "Velocidade de codar", "24/02/2026", 10, 40);
		
		esporte.inscreverAtletaEmAtividade("melina@gmail.com", id4);
		esporte.inscreverAtletaEmAtividade("livia@gmail.com", id3);
		esporte.inscreverAtletaEmAtividade("kaio@gmail.com", id2);
		esporte.inscreverAtletaEmAtividade("vitor@gmail.com", id1);
		
		String[] resultado = esporte.listarAtletas();
		
		assertEquals("Melina", resultado[0]);
		assertEquals("Livia", resultado[1]);
		assertEquals("Kaio", resultado[2]);
		assertEquals("Vitor", resultado[3]);
	}
}

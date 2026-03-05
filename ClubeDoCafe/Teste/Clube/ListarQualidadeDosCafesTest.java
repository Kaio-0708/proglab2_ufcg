package Clube;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListarQualidadeDosCafesTest {

	private ClubeDoCafeController clube;
	
	@BeforeEach
	void setUp(){
		clube = new ClubeDoCafeController();
	}

	@Test
	void validarQualidadeNota() {
		clube.cadastrarCafeEspecial("autora", "Campina", 10, 10);
		clube.cadastrarCafePremium("são", "JP", 20, 20);
		clube.cadastrarCafeTradicional("vitor", "alagoa", 30, 30);
		
		String melhor = clube.buscarCafeMelhorQualidade();
		
		assertNotNull(melhor);
	}
	
	@Test
	void validarQualidadeNome() {
		clube.cadastrarCafeEspecial("autora", "Campina", 10, 10);
		clube.cadastrarCafePremium("são", "JP", 20, 20);
		clube.cadastrarCafeTradicional("vitor", "alagoa", 30, 30);
		
		String resultado = clube.buscarCafeMelhorQualidade();
		
		assertTrue(resultado.contains("autora"));
	}
	
	@Test
	void verificarQualidadeNome() {
		clube.cadastrarCafeEspecial("autora", "Campina", 10, 10);
		clube.cadastrarCafePremium("são", "JP", 20, 20);
		clube.cadastrarCafeTradicional("vitor", "alagoa", 30, 30);
		
		String resultado = clube.buscarCafeMelhorQualidade();
		
		assertEquals("autora", resultado);
	}
}

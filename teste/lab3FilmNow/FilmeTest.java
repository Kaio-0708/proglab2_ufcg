package lab3FilmNow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import filmnow.Filme;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

class FilmeTest {
	
	@Test
	void testarAdicionarLocal() {
		Filme filme = new Filme("Avatar",2009,"Disney+");
		assertEquals(filme.adicionarLocal("Amazon"), true);
	}
	
	
}

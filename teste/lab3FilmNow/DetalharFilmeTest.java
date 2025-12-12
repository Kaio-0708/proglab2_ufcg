package lab3FilmNow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import filmnow.DetalharFilme;
import filmnow.FilmNow;
import filmnow.Filme;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DetalharFilmeTest {

	private FilmNow fn;
	
	@BeforeEach
	void preparaDetalharFilme() {
		fn = new FilmNow();
	}
	
	@Test
	void testarDetalharFilmeTodosDados() {
		fn.cadastrarFilme(5, "Avatar", "2009", "Disney");
		Filme filme = fn.getFilme(5);
		DetalharFilme df = new DetalharFilme(filme, 5);
		assertEquals(df.toString(), "\n" + filme.getNome() + ", " + filme.getAno() + "\n" + df.locaisDeExibicao());
	}
	
	@Test
	void testarDetalharFilmeSemAnoDeLancamento() {
		fn.cadastrarFilme(1, "20 dias em Mariupol", "", "Cinema");
		Filme filme = fn.getFilme(1);
		DetalharFilme df = new DetalharFilme(filme, 1);
		assertEquals(df.toString(), "\n" + filme.getNome() + "\n" + df.locaisDeExibicao());
	}
	
	@Test
	void testarDatalharFilmeEmUmaPosicaoSemFilme() {
		DetalharFilme df = new DetalharFilme(null,5);
		assertEquals(df.toString(),"");
	}
	
	@Test
	void testarDetalharFilmePosicaoAbaixoDoLimite() {
		DetalharFilme df = new DetalharFilme(null,0);
		assertEquals(df.toString(), "POSIÇÃO INVÁLIDA!");
	}
	
	@Test
	void testarDetalharFilmePosicaoAcimaDoLimite() {
		DetalharFilme df = new DetalharFilme(null,101);
		assertEquals(df.toString(), "POSIÇÃO INVÁLIDA!");
	}
	
	@Test
	void testarDetalharFilmeHotList() {
		fn.cadastrarFilme(5, "Avatar", "2009", "Disney+");
		Filme filme = fn.getFilme(5);
		fn.atribuirHot(filme, 1);
		DetalharFilme df = new DetalharFilme(filme,5);
		assertEquals(df.toString(), "\n" + "🔥" + filme.getNome() + ", " + filme.getAno() + "\n" + df.locaisDeExibicao());
	}
	
	@Test 
	void testarDetalharFilmeHotListSemLocalDeExibicao(){
		fn.cadastrarFilme(5, "Poderoso chefao", "1950", "");
		Filme filme = fn.getFilme(5);
		if (filme != null) {
	        fn.atribuirHot(filme, 1);
	    }
		DetalharFilme df = new DetalharFilme(filme, 5);
		assertEquals("", df.toString());
	}
	
	@Test 
	void testarDetalharFilmeHotListSemAno(){
		fn.cadastrarFilme(5, "Poderoso chefao", "", "Amazon");
		Filme filme = fn.getFilme(5);
		fn.atribuirHot(filme, 1);
		DetalharFilme df = new DetalharFilme(filme, 5);
		assertEquals(df.toString(), "\n" + "🔥" + filme.getNome() + "\n" + df.locaisDeExibicao());
	}
	
	@Test 
	void testarDetalharFilmeHotListComAno(){
		fn.cadastrarFilme(2, "Poderoso chefao", "1950", "Amazon");
		Filme filme = fn.getFilme(2);
		fn.atribuirHot(filme, 1);
		DetalharFilme df = new DetalharFilme(filme, 2);
		String esperado = "\n🔥Poderoso chefao, 1950\nAmazon";

	    assertEquals(esperado, df.toString());
	}
}

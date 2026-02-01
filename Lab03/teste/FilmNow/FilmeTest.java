package FilmNow;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import FilmNow.Filme;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

/**
 * @author Kaio Vitor Santos Queiroz
 */
class FilmeTest {
	
	@Test
	void testarAdicionarLocal() {
		Filme filme = new Filme("Avatar",2009,"Disney+");
		assertEquals(filme.adicionarLocal("Amazon"), true);
	}
	
	@Test
	void testarToString() {
		Filme filme = new Filme("Poderoso chefao",1950,"Disney+");
		assertEquals(filme.toString(), filme.getNome());
	} 
	
	@Test
	public void testeNomeNull() {
		try {
			Filme filme = new Filme(null,1950,"Disney+");
			if (filme.getNome() == null) {
				throw new IllegalArgumentException("FILME NULO");
			}
		} catch (IllegalArgumentException npe) {
			assertEquals("Nome não é válido.", npe.getMessage());
		}
	}
	
	@Test
	public void testeNomeVazio(){
		try {
			Filme filme = new Filme("",1950,"Disney+");
			if ("".equals(filme.getNome().trim())) {
				throw new IllegalArgumentException("Nome não é válido.");
			}
		} catch (IllegalArgumentException iae) {
			assertEquals("Nome não é válido.", iae.getMessage());
		}
	}
	
	@Test
	void testarAdicionarLocalComListaLotada() {
		Filme filme = new Filme("Poderoso chefao",1950,"Amazon");
		filme.adicionarLocal("Amazon Prime Video");
		filme.adicionarLocal("GloboPlay");
		filme.adicionarLocal("HBO");
		filme.adicionarLocal("Crunchyroll");
		assertEquals(filme.adicionarLocal("netflix"), false);
	}
	
	@Test
	void testarAdicionarLocalComMesmoNome() {
		Filme filme = new Filme("Poderoso chefao",1950,"Amazon");
		assertEquals(filme.adicionarLocal("Amazon"), false);
	}
	
	@Test
	void testarRemoverLocal() {
		Filme filme = new Filme("Poderoso chefao",1950,"Amazon");
		filme.adicionarLocal("GloboPlay");
		assertEquals(filme.removerLocal("Amazon"), true);
	}
	
	@Test
	void testarRemoverLocalComNomeErrado() {
		Filme filme = new Filme("Poderoso chefao",1950,"Amazon");
		filme.adicionarLocal("GloboPlay");
		assertEquals(filme.removerLocal("Disney"), false);
	}
	
	@Test
	void testarRemoverLocalComApenasUmLocalNaLista() {
		Filme filme = new Filme("Poderoso chefao",1950,"Amazon");
		assertEquals(filme.removerLocal("Amazon"), false);
	}
	
	@Test
	void testarQuantidadeDeLocais() {
		Filme filme = new Filme("Avatar",2009,"Disney+");
		filme.adicionarLocal("Amazon");
		filme.adicionarLocal("Netflix");
		assertEquals(filme.quantidadeDeLocais(), 3);
	}

}
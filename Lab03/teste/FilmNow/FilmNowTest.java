package FilmNow;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import FilmNow.FilmNow;
import FilmNow.Filme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Kaio Vitor Santos Queiroz
 */
class FilmNowTest {

	private FilmNow fn;
	
	@BeforeEach
	void prepararFilme() {
		fn = new FilmNow();
	}
	
	@Test
	void testarAdicionarFilmePosicaoVazia() {
		assertEquals(fn.cadastrarFilme(5, "Avatar", "2009", "Disney+"), "FILME ADICIONADO");
	}
    
	@Test
	void testarAdicionarFilmePosicaoExistente() {
		fn.cadastrarFilme(5, "Avatar", "2009", "Disney+");
		assertEquals(fn.cadastrarFilme(5, "20 dias em Mariupol", "2023", "Cinema"), "FILME ADICIONADO");
	}
	
	@Test 
	void testarAdicionarFilmeJaAdicionado() {
		fn.cadastrarFilme(1, "Avatar", "2009", "Disney+");
		assertEquals(fn.cadastrarFilme(3, "Avatar", "2009", "Disney+"), "FILME JÁ ADICIONADO");
	}
	
	@Test
	void testarAdicionarFilmeLocalDiferentes() {
		fn.cadastrarFilme(1, "Avatar", "2009", "Disney+");
		assertEquals(fn.cadastrarFilme(3, "Avatar", "2009", "Popcornflix"), "FILME JÁ ADICIONADO");
	}
	
	@Test
	void testarAdicionarFilmePosicaoLimite() {
		assertEquals(fn.cadastrarFilme(100, "Avatar", "2009", "Disney+"), "FILME ADICIONADO");
	}
	
	@Test
	void testarAdicionarFilmePosicaoAcimaLimite() {
		assertEquals(fn.cadastrarFilme(101, "Avatar", "2009", "Disney+"), "POSIÇÃO INVÁLIDA" );
	}
	
	@Test
	void testarAdicionarFilmePosicaoAbaixoLimite() {
		assertEquals(fn.cadastrarFilme(0, "Avatar", "2009", "Disney+"), "POSIÇÃO INVÁLIDA" );
	}
	
	@Test
	void testarAdicionarFilmeLocalVazio() {
		assertEquals(fn.cadastrarFilme(1, "20 dias em Mariupol", "2023", ""), "FILME INVALIDO");
	}
	
	@Test
	void testarAdicionarFilmeAnoLancamentoVazio() {
		assertEquals(fn.cadastrarFilme(1, "20 dias em Mariupol", "", "Cinema"), "FILME ADICIONADO");
	}
	
	@Test
	void testarAdicionarFilmeNomeVazio() {
		assertEquals(fn.cadastrarFilme(1, "", "2023", "Cinema"), "FILME INVALIDO");
	}
	
	@Test 
	void testarAdicionarNaHotList() {
		fn.cadastrarFilme(5, "Avatar", "2009", "Disney+");
		assertEquals(fn.atribuirHot(fn.getFilme(5), 1), "FILME ADICIONADO");
	}
	
	@Test
	void testarAdicionarFilmeJaExistenteNaHotList() {
		fn.cadastrarFilme(5, "Poderoso chefão", "2009", "Disney+");
		Filme filme1 = fn.getFilme(5);
		Filme filme2 = fn.getFilme(5);
		fn.atribuirHot(filme1, 1);
		assertEquals(fn.atribuirHot(filme2, 2), "FILME JÁ ADICIONADO");
	}
	
	@Test
	void testarAdicionarNaHotListAbaixoDoLimite() {
		fn.cadastrarFilme(5, "Poderoso chefão", "2009", "Disney+");
		assertEquals(fn.atribuirHot(fn.getFilme(5), 0), "POSIÇÃO INVÁLIDA.");
	}
	
	@Test
	void testarAdicionarNaHotListAcimaDoLimite() {
		fn.cadastrarFilme(5, "Poderoso chefão", "2009", "Disney+");
		assertEquals(fn.atribuirHot(fn.getFilme(5), 11), "POSIÇÃO INVÁLIDA.");
	}
	
	@Test
	void testarAdicionarPosicaoVaziaNaHotList() {
		assertEquals(fn.atribuirHot(fn.getFilme(80), 1), "FILME INVÁLIDO, POSIÇÃO VAZIA");
	}
	
	@Test
	void testarRemoverDaHotList() {
		fn.cadastrarFilme(5, "Avatar", "2009", "Disney+");
		fn.atribuirHot(fn.getFilme(5), 1);
		assertEquals(fn.removerHot(1), true);
	}
	
	@Test
	void testarRemoverDeUmaPosicaoNullNaHotList() {
		assertEquals(fn.removerHot(1), false);
	}
	
	@Test
	void testarRemoverAbaixoDoLimiteDaHotList() {
		assertEquals(fn.removerHot(0), false);
	}
	
	@Test
	void testarRemoverAcimaDoLimiteDaHotList() {
		assertEquals(fn.removerHot(11), false);
	}
	
	@Test
	void testarExibirHotList() {
		fn.cadastrarFilme(5, "Avatar", "2009", "Disney+");
		fn.cadastrarFilme(6, "20 dias em Mariupol","2023", "Cinema");
		Filme filme = fn.getFilme(5);
		Filme filme2 = fn.getFilme(6);
		fn.atribuirHot(filme, 2);
		fn.atribuirHot(filme2, 6);
		assertEquals(fn.exibirHotList(), 2 + " - " + filme.getNome() + ", " + filme.getAno() + "\n"
				+ 6 + " - " + filme2.getNome() + ", " + filme2.getAno() + "\n");
	}
	
	@Test 
	void testarRemoverFilme() {
		fn.cadastrarFilme(5, "Poderoso chefão", "2009", "Disney+");
		assertEquals(fn.removerFilme(5), true);
	}
	
	@Test 
	void testarRemoverFilmeEmPosicaoVazia() {
		assertEquals(fn.removerFilme(50), false);
	}
	
	@Test 
	void testarRemoverFilmeAbaixoDoLimite() {
		assertEquals(fn.removerFilme(0), false);
	}
	
	@Test 
	void testarRemoverFilmeAcimaDoLimite() {
		assertEquals(fn.removerFilme(101), false);
	}
	
	@Test
	void testarRemoverFilmeTambemDaHotList() {
		fn.cadastrarFilme(5, "Poderoso chefão", "2009", "Disney+");
		fn.atribuirHot(fn.getFilme(5), 1);
		assertEquals(fn.removerFilme(5), true);
		assertEquals(fn.exibirHotList(), "");
	}
	
	@Test
	void testarMostrarTodosPeloNome() {
		fn.cadastrarFilme(5, "Poderoso chefão", "2009", "Disney+");
		fn.cadastrarFilme(8, "Poderoso chefão", "2020", "Netflix");
		fn.cadastrarFilme(60, "Poderoso chefão", "2000", "Amazon");
		assertEquals(fn.mostrarTodosPeloNome("Poderoso chefão"), 5 + " - " + "Poderoso chefão" + "\n" +
		8 + " - " + "Poderoso chefão" + "\n" + 60 + " - " + "Poderoso chefão" + "\n");
	}
	
	@Test
	void testarMostrarTodosPeloNomeInexistente() {
		assertEquals(fn.mostrarTodosPeloNome("Shrek 3"), "");
	}
	
	@Test
	void testarMostrarTodosPeloAno() {
		fn.cadastrarFilme(5, "Avatar", "2009", "Disney+");
		fn.cadastrarFilme(7, "Poderoso chefão", "2009", "Netflix");
		fn.cadastrarFilme(30, "Esqueceram de mim", "2009", "Amazon");
		assertEquals(fn.mostrarTodosPeloAno(2009), 5 + " - " + "Avatar" + "\n" +
				7 + " - " + "Poderoso chefão" + "\n" + 30 + " - " + "Esqueceram de mim" + "\n");
	}
	
	@Test
	void testarMostrarTodosPeloAnoInexistente() {
		assertEquals(fn.mostrarTodosPeloAno(50), "");
		assertEquals(fn.mostrarTodosPeloAno(-30), "");
	}
}
package BD;

import java.util.ArrayList;
import java.util.List;

public class Cientifico extends Livro{

	private int numPaginas;
	
	public Cientifico(String titulo, String autor, String data, int maxEmprestimos, int numPaginas) {
		super(titulo, autor, data, maxEmprestimos);
		this.numPaginas = numPaginas;
	}

	@Override
	public int gerarPontos() {
		return numPaginas;
	}

	@Override
	public String informarDetalhes() {
		String informacao = "Titulo: " + titulo + "\n Autor: " + autor + "\n Data: " + data + "\n Max Emprestimos: " + maxEmprestimos + "\n Número de páginas: " + numPaginas + "\n Pontuacao: " + gerarPontos();
		
		List<Leitor> leitor = new ArrayList<>(leitores.values());
		
		for(int i = 0 ; i < leitor.size(); i++) {
			informacao = informacao + "\n Leitor: " + leitor.get(i).getNome();
		}
		
		return informacao;
	}
}

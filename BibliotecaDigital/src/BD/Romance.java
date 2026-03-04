package BD;

import java.util.ArrayList;
import java.util.List;

public class Romance extends Livro{

	public Romance(String titulo, String autor, String data, int maxEmprestimos) {
		super(titulo, autor, data, maxEmprestimos);
	}

	@Override
	public int gerarPontos() {
		return 2;
	}

	@Override
	public String informarDetalhes() {
		String informacao = "Titulo: " + titulo + "\n Autor: " + autor + "\n Data: " + data + "\n Max Emprestimos: " + maxEmprestimos + "\n Pontuacao: " + gerarPontos();
		
		List<Leitor> leitor = new ArrayList<>(leitores.values());
		
		for(int i = 0 ; i < leitor.size(); i++) {
			informacao = informacao + "\n Leitor: " + leitor.get(i).getNome();
		}
		
		return informacao;
	}
}

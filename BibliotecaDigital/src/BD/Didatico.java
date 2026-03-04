package BD;

import java.util.ArrayList;
import java.util.List;

public class Didatico extends Livro{

	private int numPaginas;
	private boolean geraPontosExtras;
	
	public Didatico(String titulo, String autor, String data, int maxEmprestimos, int numPaginas, boolean geraPontosExtras) {
		super(titulo, autor, data, maxEmprestimos);
		this.numPaginas = numPaginas;
		this.geraPontosExtras = geraPontosExtras;
	}

	@Override
	public int gerarPontos() {
		int valor = 0;
		
		if(geraPontosExtras) {
			valor = numPaginas + 5;
		} else {
			valor = numPaginas;
		}
		
		return valor;
	}

	@Override
	public String informarDetalhes() {
		String informacao = "Titulo: " + titulo + "\n Autor: " + autor + "\n Data: " + data + "\n Max Emprestimos: " + maxEmprestimos + "\n Número de páginas: " + numPaginas + "\n Pontuacao: " + gerarPontos();
		
		if(geraPontosExtras) {
			informacao = informacao + "\n Gerou pontos extras";
		} else {
			informacao = informacao + "\n Não gerou pontos extras";
		}
		
		List<Leitor> leitor = new ArrayList<>(leitores.values());
		
		for(int i = 0 ; i < leitor.size(); i++) {
			informacao = informacao + "\n Leitor: " + leitor.get(i).getNome();
		}
		
		return informacao;
	}
}

package Game;

import java.util.ArrayList;
import java.util.List;

public class Campeonato extends Torneio{

	private int duracao;
	
	public Campeonato(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		super(titulo, descricao, data, maxParticipantes);
		this.duracao = duracao;
	}

	@Override
	public String detalhes() {
		String informacao = titulo + ", " + descricao + ", " + data + ", " + calcularPontuacao() + ", " + duracao + ", ";
		
		List<Jogador> jogador = new ArrayList<>(jogadores.values());
		
		for(int i = 0; i < jogador.size(); i++) {
			informacao = informacao + jogador.get(i).getNome();		
		}
		
		return informacao;
	}

	@Override
	public int calcularPontuacao() {
		return duracao;
	}
}

package Game;

import java.util.ArrayList;
import java.util.List;

public class DesafioRapido extends Torneio{

	public DesafioRapido(String titulo, String descricao, String data, int maxParticipantes) {
		super(titulo, descricao, data, maxParticipantes);
	}

	@Override
	public String detalhes() {
		String informacao = titulo + ", " + descricao + ", " + data + ", " + calcularPontuacao() + ", ";
		
		List<Jogador> jogador = new ArrayList<>(jogadores.values());
		
		for(int i = 0; i < jogador.size(); i++) {
			informacao = informacao + jogador.get(i).getNome();		
		}
		
		return informacao;
	}

	@Override
	public int calcularPontuacao() {
		return 2;
	}
}

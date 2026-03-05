package Game;

import java.util.ArrayList;
import java.util.List;

public class Maratona extends Torneio{
    
	private int duracao;
	private boolean bonus;
	
	public Maratona(String titulo, String descricao, String data, int maxParticipantes, int duracao, boolean bonus) {
		super(titulo, descricao, data, maxParticipantes);
		this.duracao = duracao;
		this.bonus = bonus;
	}

	@Override
	public String detalhes() {
		String informacao = titulo + ", " + descricao + ", " + data + ", " + calcularPontuacao() + ", " + duracao + ", ";
		
		if(bonus) {
			informacao = informacao + "Bônus ativado, ";
		} else {
			informacao = informacao + "Bônus não ativado, ";
		}
		
		List<Jogador> jogador = new ArrayList<>(jogadores.values());
		
		for(int i = 0; i < jogador.size(); i++) {
			informacao = informacao + jogador.get(i).getNome();		
		}
		
		return informacao;
	}

	@Override
	public int calcularPontuacao() {
		int resultado = 0;
		
		if(bonus) {
			resultado = duracao + 10;
		} else {
			resultado = duracao;
		}
		
		return resultado;
	}
}

package Game;

import java.util.HashMap;

public abstract class Torneio {
	
	protected String titulo;
	protected String descricao;
	protected String data;
	protected int maxParticipantes;
	protected HashMap<String, Jogador> jogadores;
	
	public Torneio(String titulo, String descricao, String data, int maxParticipantes) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.maxParticipantes = maxParticipantes;
		this.jogadores = new HashMap<>();
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getData() {
		return data;
	}
	
	public int getMaxParticipantes() {
		return maxParticipantes;
	}
	
	public HashMap<String, Jogador> getJogadores(){
		return jogadores;
	}
	
	public abstract String detalhes();
	
	public abstract int calcularPontuacao();
	
	public boolean inscreverJogador(Jogador jogador) {
		if(jogadores.containsKey(jogador.getEmail())) {
			throw new IllegalArgumentException("Jogador já inscrito!");
		}
		
		if(jogadores.size() >= maxParticipantes) {
			throw new IllegalArgumentException("Quantidade excedida!");
		}
		
		jogador.contarNumTorneiosDisputados();
		jogador.calcularPontos(calcularPontuacao());
		jogadores.put(jogador.getEmail(), jogador);
		
		return true;
	}
}

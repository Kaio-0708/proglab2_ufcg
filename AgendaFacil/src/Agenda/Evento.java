package Agenda;

import java.util.HashMap;

public abstract class Evento {
	protected String titulo;
	protected String descricao;
	protected String data;
	protected int maxParticipantes;
	protected HashMap<String, Estudante> participantes;
	
	public Evento(String titulo, String descricao, String data, int maxParticipantes) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.maxParticipantes = maxParticipantes;
		this.participantes = new HashMap<>();
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
	
	public HashMap<String, Estudante> getParticipantes(){
		return participantes;
	}
	
	public boolean inscreverParticipante(Estudante participante) {
		if(participantes.size() >= maxParticipantes) {
			return false;
		}
		
		if(participantes.containsKey(participante.getEmail())) {
			return false;
		}
		
		participantes.put(participante.getEmail(), participante);
		return true;
	}
	
	public abstract String exibirDetalhes();
	
	public abstract int calcularPontuacao();
	
}



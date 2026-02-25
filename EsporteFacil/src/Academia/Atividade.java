package Academia;

import java.util.HashMap;

public abstract class Atividade {
	protected String titulo;
	protected String descricao;
	protected String data;
	protected int maxParticipantes;
	protected HashMap<String, Atleta> atletas;
	
	public Atividade(String titulo, String descricao, String data, int maxParticipantes) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.maxParticipantes = maxParticipantes;
		this.atletas = new HashMap<>();
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
	
	public HashMap<String, Atleta> getAtletas(){
		return atletas;
	}
	
	public boolean inscreverAtleta(Atleta atleta) {
		if(atletas.size() >= maxParticipantes) {
			throw new IllegalArgumentException("Atingiu quantidade limite!");
		}
		
		if(atletas.containsKey(atleta.getEmail())) {
			throw new IllegalArgumentException("Atleta já cadastrado!");
		}
		
		atletas.put(atleta.getEmail(), atleta);
		atleta.adicionarPontos(calcularPontuacao());
		atleta.adicionarCompeticao();
		atleta.adicionarTreino();
		
		return true;
	}
	
	public abstract String toString();
	
	public abstract int calcularPontuacao();
}

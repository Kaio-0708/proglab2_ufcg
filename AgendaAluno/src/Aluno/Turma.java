package Aluno;

import java.util.HashMap;

public abstract class Turma {
	
	protected String titulo;
	protected String descricao;
	protected String data; 
	protected int maxParticipantes;
	protected HashMap<String, Estudante> estudantes;
	
	public Turma(String titulo, String descricao, String data, int maxParticipantes) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.maxParticipantes = maxParticipantes;
		this.estudantes = new HashMap<>();
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
	
	public HashMap<String, Estudante> getEstudantes(){
		return estudantes;
	}
	
	public boolean matricularEstudante(Estudante estudante) {
		if(estudantes.size() >= maxParticipantes) {
			throw new IllegalArgumentException("Capacidade máxima atingida!");
		}
		
		if(estudantes.containsKey(estudante.getEmail())) {
			throw new IllegalArgumentException("Estudante já matrículado!");
		}
		
		estudante.addNumEvento();
		estudante.addPontos(calcularPontuacao());
		estudantes.put(estudante.getEmail(), estudante);
		
		return true;
	}
	
	public abstract String exibirDetalhes();
	
	public abstract int calcularPontuacao();
}

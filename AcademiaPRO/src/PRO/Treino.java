package PRO;

import java.util.HashMap;

public abstract class Treino {
	protected String nome;
	protected int intensidade;
	protected int capacidade;
	protected HashMap<String, Aluno> alunos;
	
	public Treino(String nome, int intensidade, int capacidade) {
		this.nome = nome;
		this.intensidade = intensidade;
		this.capacidade = capacidade;
		this.alunos = new HashMap<>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getIntensidade() {
		return intensidade;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	
	public HashMap<String, Aluno> getAlunos(){
		return alunos;
	}
	
	public boolean inscreverAluno(Aluno aluno) {
		if(alunos.size() >= capacidade) {
			throw new IllegalArgumentException("Capacidade já atingida!");
		}
		
		if(alunos.containsKey(aluno.getCpf())) {
			throw new IllegalArgumentException("Aluno ja inscritos!");
		}
		
		alunos.put(aluno.getCpf(), aluno);
		aluno.addPontuacao(calcularPontos());
		aluno.addTreino();
		
		return true;
	}
	
	public abstract int calcularPontos();
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\n Intensidade: " + intensidade + "\n Capacidade: " + capacidade;
	}
}

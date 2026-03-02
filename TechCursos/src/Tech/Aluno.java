package Tech;

import java.util.Objects;

public class Aluno {
	
	private String nome;
	private String matricula;
	private int pontos;
	
	public Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
		this.pontos = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public void addPontos(int novosPontos) {
		pontos += novosPontos;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\n Matrícula: " + matricula + "\n Pontos: " + pontos;
	}
}

package PRO;

import java.util.Objects;

public class Aluno {
	private String nome;
	private String cpf;
	private int pontuacao;
	private int quantidadeTreino;
	
	public Aluno(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.pontuacao = 0;
		this.quantidadeTreino = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public int getQuantidadeTreino() {
		return quantidadeTreino;
	}
	
	public void addPontuacao(int pontuacaoAcumulada) {
		pontuacao += pontuacaoAcumulada;
	}
	
	public void addTreino() {
		this.quantidadeTreino ++;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
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
		return Objects.equals(cpf, other.cpf);
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\n Quantidade de treinos realizados: " + quantidadeTreino + "\n Pontuacao Acumulada: " + pontuacao;
	}
}

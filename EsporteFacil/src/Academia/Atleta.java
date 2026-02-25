package Academia;

import java.util.Objects;

public class Atleta {
	private String nome;
	private String email;
	private int pontuacao;
	private int quantidadeTreino;
	private int quantidadeCompeticao;
	
	public Atleta(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.pontuacao = 0;
		this.quantidadeCompeticao = 0;
		this.quantidadeTreino = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public int getQuantidadeCompeticao() {
		return quantidadeCompeticao;
	}
	
	public int getQuantidadeTreino() {
		return quantidadeTreino;
	}
	
	public void adicionarPontos(int pontosRecebidos) {
		this.pontuacao += pontosRecebidos;
	}
	
	public void adicionarCompeticao() {
		this.quantidadeCompeticao ++;
	}
	
	public void adicionarTreino() {
		this.quantidadeTreino ++;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		return Objects.equals(email, other.email);
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\n Números de Treinos: " + quantidadeTreino + "\n Números de Competicoes: " + quantidadeCompeticao + "\n Pontuacao: " + pontuacao;
	}
}
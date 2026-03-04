package BD;

import java.util.Objects;

public class Leitor {
	
	private String nome;
	private String email;
	private int pontos;
	private int numLivroEmprestado;
	
	public Leitor(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.pontos = 0;
		this.numLivroEmprestado = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public int getNumLivroEmprestado() {
		return numLivroEmprestado;
	}
	
	public void addLivroEmprestado() {
		this.numLivroEmprestado ++;
	}
	
	public void addPontos(int novoPonto) {
		pontos += novoPonto;
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
		Leitor other = (Leitor) obj;
		return Objects.equals(email, other.email);
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\n Número de livros emprestados: " + numLivroEmprestado + "\n Pontos de leitura: " + pontos;
	}
}

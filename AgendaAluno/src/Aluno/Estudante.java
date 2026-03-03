package Aluno;

import java.util.Objects;

public class Estudante {
	
	private String nome;
	private String email;
	private int numEventos;
	private int pontos;
	
	public Estudante(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.numEventos = 0;
		this.pontos = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getNumEventos() {
		return numEventos;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public void addPontos(int novoPonto) {
		pontos += novoPonto;
	}
	
	public void addNumEvento() {
		this.numEventos ++;
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
		Estudante other = (Estudante) obj;
		return Objects.equals(email, other.email);
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\n Número de Eventos: " + numEventos + "\n Pontuacao: " + pontos;
	}
}

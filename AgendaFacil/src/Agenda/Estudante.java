package Agenda;

import java.util.Objects;

public class Estudante {
	private String nome;
	private String email;
	private int pontos;
	private int quantidadeEventoParticipa;
	
	public Estudante(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.pontos = 0;
		this.quantidadeEventoParticipa = 0;
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
	
	public int getQuantidadeEventoParticipa() {
		return quantidadeEventoParticipa;
	}
	
	public void adicionarEvento() {
		this.quantidadeEventoParticipa ++;
	}
	
	public void adicionarPontos(int pontosRecebidos) {
		this.pontos += pontosRecebidos;
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
		return "Nome: " + nome + "\n Quantidade de eventos que participa: " + quantidadeEventoParticipa + "\n Quantidade de pontos: " + pontos;
	}
}

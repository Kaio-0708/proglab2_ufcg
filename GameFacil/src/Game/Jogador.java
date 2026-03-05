package Game;

import java.util.Objects;

public class Jogador {
	
	private String nome;
	private String email;
	private int pontuacao;
	private int numTorneioDisputados;
	
	public Jogador(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.pontuacao = 0;
		this.numTorneioDisputados = 0;
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
	
	public int getNumTorneioDisputados() {
		return numTorneioDisputados;
	}
	
	public void calcularPontos(int novoPonto) {
		pontuacao += novoPonto;
	}
	
	public void contarNumTorneiosDisputados() {
		this.numTorneioDisputados ++;
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
		Jogador other = (Jogador) obj;
		return Objects.equals(email, other.email);
	}
	
	@Override
	public String toString() {
		return nome + ", " + numTorneioDisputados + ", " + pontuacao;
	}
}

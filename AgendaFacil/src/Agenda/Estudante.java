package Agenda;

import java.util.Objects;

public class Estudante {
	private String nome;
	private String email;
	private int ponto;
	
	public Estudante(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.ponto = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getPonto() {
		return ponto;
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
}
